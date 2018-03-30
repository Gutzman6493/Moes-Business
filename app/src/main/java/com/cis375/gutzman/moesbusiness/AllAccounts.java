/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: This is the global static list
        of all accounts held by the application.
*/
package com.cis375.gutzman.moesbusiness;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class AllAccounts
{
    static ArrayList<Account> TheAccounts = new ArrayList<Account>(0);
    // For development purposes (managers login info kept here in array)
    private String[][] managers = new String[][]
            {
                    {"moe", "moe01"},
                    {"root", "root01"}
            };

    public AllAccounts() {} // Empty Constructor

    // Should only be used to create manager accounts
    public void addAccountFromFile(File path)
    {
        try
        {
            File accountFile = new File("AccountFile.txt");
            if(accountFile.exists())
            {
                String fileLine;
                Scanner fileInput = new Scanner(accountFile);
                Account temp;
                while (fileInput.hasNextLine())
                {
                    fileLine = fileInput.nextLine();
                    fileLine = fileLine.replace("\n", " ");
                    String[] fileWords = fileLine.split(" ");
                    temp = new Account(fileWords[0], fileWords[1]);
                    temp.setManagerFlag(true);
                    TheAccounts.add(temp);
                }
                fileInput.close();
            }
        }
        catch (IOException e)
        {
            System.out.print(e);
        }
    }// End addAccountFromFile

    // Used for customers to create account
    public void addAccount(Account newAccount)
    {
        synchronized(TheAccounts)
        {
            TheAccounts.add(newAccount);
        }
    }// End addAccount

    // Login the user (for both customer and manager)
    public boolean loginUser(String uN, String pW)
    {
        for(int i = 0; i < TheAccounts.size(); i++)
        {
            if(TheAccounts.get(i).getUsername().equals(uN))
            {
                if(TheAccounts.get(i).getPassword().equals(pW))
                {
                    return true;
                }
            }
        }
        return false;
    }// End login

    public boolean checkManagerFlag(String uN)
    {
        for (int i = 0; i < TheAccounts.size(); i++)
        {
            if (TheAccounts.get(i).getUsername().equals(uN))
            {
                return TheAccounts.get(i).getManagerFlag();
            }

        }
        return false;
    }// End checkManagerFlag

    public String handleForgotPassword(String uN)
    {
        for (int i = 0; i < TheAccounts.size(); i++)
        {
            if (TheAccounts.get(i).getUsername().equals(uN))
            {
                if(!TheAccounts.get(i).getManagerFlag())
                {
                    return TheAccounts.get(i).getPassword();
                }
                else
                {
                    return "CALL US FOR RESET";
                }
            }

        }
        return "ACCOUNT NOT FOUND";
    }// End handleForgotPassword

    // For development purposes till fixed later
    public void addManagerAccounts()
    {
        synchronized(TheAccounts)
        {
            for(int i = 0; i < managers.length; i++)
            {
                Account temp = new Account(managers[i][0], managers[i][1]);
                temp.setManagerFlag(true);
                TheAccounts.add(temp);
            }
        }

    }// End addManagerAccounts
}
