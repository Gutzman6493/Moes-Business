/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Initial activity launched. This activity
        logs the user in / directs them to the next step which
        could be customer / manager views, create account, or
        forgot password
*/
package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.content.*;

import java.io.File;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment
    implements View.OnClickListener
{

    private EditText usernameText;
    private EditText passwordText;
    private Button loginBtn;
    private Button forgotBtn;
    private Button createBtn;
    private static String username = "";
    private static String password = "";
    private boolean loggedInFlag;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public LoginFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Assign widget variables
        usernameText = (EditText) view.findViewById(R.id.usernameText);
        passwordText = (EditText) view.findViewById(R.id.passwordText);
        loginBtn = (Button) view.findViewById(R.id.loginBtn);
        forgotBtn = (Button) view.findViewById(R.id.forgotBtn);
        createBtn = (Button) view.findViewById(R.id.createBtn);

        // Setup listeners
        usernameText.setOnClickListener(this);
        passwordText.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        forgotBtn.setOnClickListener(this);
        createBtn.setOnClickListener(this);

        // Setup Preferences
        prefs = this.getActivity().getSharedPreferences("preferences", MODE_PRIVATE);

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.usernameText:
                // If usernameText clicked, remove the text.
                usernameText.setText("");
                break;
            case R.id.passwordText:
                // If passwordText clicked, remove the text.
                passwordText.setText("");
                break;
            case R.id.loginBtn:
                // On click, see if username / password match an account
                handleLogin();
                break;
            case R.id.forgotBtn:
                handleForgot();
                break;
            case R.id.createBtn:
                handleCreate();
                break;
        }
    }//End onClick MainActivity
    public void handleLogin()
    {

        username = usernameText.getText().toString().trim();
        password = passwordText.getText().toString().trim();
        loggedInFlag = AllAccounts.loginUser(username, password);
        if(loggedInFlag)
        {
            // Save the username to preferences for easier access to individual accounts
            editor = prefs.edit();
            editor.putString("Username", username);
            editor.commit();
            // User successfully logged in, start right activity
            if(AllAccounts.checkManagerFlag(username))
            {
                // If they're the manager send them to the manager activity
                editor = prefs.edit();
                editor.putBoolean("accountFile", true);
                editor.commit();
                startActivity(new Intent(getActivity(), ManagerActivity.class));
                Toast.makeText(this.getActivity().getApplicationContext(),
                        "Simulate Manager Activity Opened",
                        Toast.LENGTH_SHORT).show();
            }
            else
            {
                // They're not the manager, send them to the customer activity
                editor = prefs.edit();
                editor.putBoolean("accountFile", false);
                editor.commit();
                startActivity(new Intent(getActivity(), CustomerActivity.class));
                Toast.makeText(this.getActivity().getApplicationContext(),
                        "Simulate Customer Activity Opened",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            // User did not successfully log in, tell them
            Toast.makeText(this.getActivity().getApplicationContext(),
                    "Invalid Username/Password",
                    Toast.LENGTH_SHORT).show();
        }
    }// End handleLogin

    // If hit, will load new activity asking for username
    //  will then search for that username and tell the user their password
    public void handleForgot()
    {
        MainActivity.showForgot();
    }// End handleForgot

    public void handleCreate()
    {
        MainActivity.showCreateAccount();
    }
}
