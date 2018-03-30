/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: This activity is for new users
        they will enter the appropriate information and
        have an account created, given their desired
        username isn't already taken.
*/
package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountFragment extends Fragment
    implements View.OnClickListener
{
    private EditText usernameText;
    private EditText passwordText;
    private EditText firstNameText;
    private EditText lastNameText;
    private EditText stAddressText;
    private EditText cityText;
    private EditText stateText;
    private EditText zipcodeText;
    private Button createBtn;
    private AllAccounts userAccounts;

    public CreateAccountFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_account, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get accounts so you can add the new one
        userAccounts = new AllAccounts();

        // Assign widget variables
        usernameText = (EditText) view.findViewById(R.id.usernameText);
        passwordText = (EditText) view.findViewById(R.id.passwordText);
        firstNameText = (EditText) view.findViewById(R.id.firstNameText);
        lastNameText = (EditText) view.findViewById(R.id.lastNameText);
        stAddressText = (EditText) view.findViewById(R.id.stAddressText);
        cityText = (EditText) view.findViewById(R.id.cityText);
        stateText = (EditText) view.findViewById(R.id.stateText);
        zipcodeText = (EditText) view.findViewById(R.id.zipcodeText);
        createBtn = (Button) view.findViewById(R.id.createBtn);

        // Setup listeners
        usernameText.setOnClickListener(this);
        passwordText.setOnClickListener(this);
        firstNameText.setOnClickListener(this);
        lastNameText.setOnClickListener(this);
        stAddressText.setOnClickListener(this);
        cityText.setOnClickListener(this);
        stateText.setOnClickListener(this);
        zipcodeText.setOnClickListener(this);
        createBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        boolean created;
        switch (v.getId())
        {
            case R.id.usernameText:
                usernameText.setText("");
                break;
            case R.id.passwordText:
                passwordText.setText("");
                break;
            case R.id.firstNameText:
                firstNameText.setText("");
                break;
            case R.id.lastNameText:
                lastNameText.setText("");
                break;
            case R.id.stAddressText:
                stAddressText.setText("");
                break;
            case R.id.cityText:
                cityText.setText("");
                break;
            case R.id.stateText:
                stateText.setText("");
                break;
            case R.id.zipcodeText:
                zipcodeText.setText("");
                break;
            case R.id.createBtn:
                created = handleCreate();
                if(created)
                {
                    Toast.makeText(this.getActivity().getApplicationContext(),
                            "Account Created",
                            Toast.LENGTH_SHORT).show();
                    MainActivity.removeFrag(this);
                }
                break;
        }
    }// End onClick

    public boolean handleCreate()
    {
        // First, check to make sure the user filled out all the fields
        if(usernameText.getText().toString().isEmpty() ||
                passwordText.getText().toString().isEmpty() ||
                firstNameText.getText().toString().isEmpty()||
                lastNameText.getText().toString().isEmpty() ||
                stAddressText.getText().toString().isEmpty() ||
                cityText.getText().toString().isEmpty() ||
                stateText.getText().toString().isEmpty() ||
                zipcodeText.getText().toString().isEmpty()
            )
        {
            // If any field is empty do nothing but tell the user
            Toast.makeText(this.getActivity().getApplicationContext(),
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        // If all fields filled in check to see if username is taken
        for(int i = 0; i < userAccounts.TheAccounts.size(); i++)
        {
            if(userAccounts.TheAccounts.get(i).getUsername().equals(usernameText.getText().toString()))
            {
                // If its taken don't allow it to happen and tell the user to change it
                Toast.makeText(this.getActivity().getApplicationContext(),
                        "Username is taken",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        Account temp = new Account(usernameText.getText().toString(),
                passwordText.getText().toString());
        temp.setFirstName(firstNameText.getText().toString());
        temp.setLastName(lastNameText.getText().toString());
        temp.setStAddress(stAddressText.getText().toString());
        temp.setCity(cityText.getText().toString());
        temp.setState(stateText.getText().toString());
        temp.setZipCode(zipcodeText.getText().toString());
        userAccounts.addAccount(temp);
        return true;
    }// End handleCreate
}
