/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: This activity is for when the user has
        forgotten their password, currently the user simply
        needs to enter their username and their password
        will be given. For this project, we will have a
        simulated security system.
*/

package com.cis375.gutzman.moesbusiness;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotFragment extends Fragment
    implements View.OnClickListener
{
    private EditText usernameText;
    private Button getBtn;
    private TextView pwTitleText;
    private TextView passwordText;

    public ForgotFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Assign widget variables
        usernameText = (EditText) view.findViewById(R.id.usernameText);
        getBtn = (Button) view.findViewById(R.id.getBtn);
        pwTitleText = (TextView) view.findViewById(R.id.pwTitleText);
        passwordText = (TextView) view.findViewById(R.id.passwordText);

        // Set the passwords to invisible on create until the user is ready
        pwTitleText.setVisibility(View.INVISIBLE);
        passwordText.setVisibility(View.INVISIBLE);

        // Setup listeners
        usernameText.setOnClickListener(this);
        getBtn.setOnClickListener(this);
    } // End onCreate

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.usernameText:
                // If usernameText clicked, remove the text.
                usernameText.setText("");
                break;
            case R.id.getBtn:
                handleForgot();
                break;
        }
    }//End onClick

    public void handleForgot()
    {
        String username = usernameText.getText().toString();
        String password;
        password = AllAccounts.handleForgotPassword(username);
        pwTitleText.setVisibility(View.VISIBLE);
        passwordText.setText(password);
        passwordText.setVisibility(View.VISIBLE);
    }// End handleForgot
}
