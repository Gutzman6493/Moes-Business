/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: This is the class for accounts
*/
package com.cis375.gutzman.moesbusiness;

import java.util.ArrayList;

public class Account
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String stAddress;
    private String zipCode;
    private String city;
    private String state;
    private boolean managerFlag = false;
    //private ArrayList<Item> shoppingCart; // FIXME will implement later

    public Account() {} // Empty Constructor

    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    // GETTERS AND SETTERS FOLLOW
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setFirstName(String name)
    {
        firstName = name;
    }
    public void setLastName(String name)
    {
        lastName = name;
    }
    public void setStAddress(String address)
    {
        stAddress = address;
    }
    public void setZipCode(String zip)
    {
        zipCode = zip;
    }
    public void setCity(String name)
    {
        city = name;
    }
    public void setState(String name)
    {
        state = name;
    }
    public void setManagerFlag(boolean flag)
    {
        managerFlag = flag;
    }
    public boolean getManagerFlag()
    {
        return managerFlag;
    }
    // END GETTERS AND SETTERS

    // View pastOrders
    public String viewPastOrders()
    {
        // Files will be (global || username)Orders.txt
        // If manager load the global order list
        if(managerFlag)
        {

        }
        // If customer load the customers order file
        else
        {

        }

        return "Fuck off";
    }
}
