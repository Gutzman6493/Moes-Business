/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: This is the global static list
        of all accounts held by the application.
*/
package com.cis375.gutzman.moesbusiness;

import java.util.ArrayList;

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

    // Get the customer's account
    public static Account getAccount(String username)
    {
        for(int i = 0; i < TheAccounts.size(); i++)
        {
            if(TheAccounts.get(i).getUsername().equals(username))
            {
                return TheAccounts.get(i);
            }
        }

        return null;
    }
}
