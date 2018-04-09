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
    private static String[][] managers = new String[][]
            {
                    {"moe", "moe01"},
                    {"root", "root01"},
                    {"admin", "admin01"}
            };

    public AllAccounts() {} // Empty Constructor

    // Used for customers to create account
    public static void addAccount(Account newAccount)
    {
        synchronized(TheAccounts)
        {
            TheAccounts.add(newAccount);
        }
    }// End addAccount

    // Login the user (for both customer and manager)
    public static boolean loginUser(String uN, String pW)
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

    public static boolean checkManagerFlag(String uN)
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

    public static String handleForgotPassword(String uN)
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
    public static void addManagerAccounts()
    {
        for(int i = 0; i < managers.length; i++)
        {
            Account temp = new Account(managers[i][0], managers[i][1]);
            temp.setManagerFlag(true);
            AllAccounts.addAccount(temp);
        }

    }// End addManagerAccounts
}
