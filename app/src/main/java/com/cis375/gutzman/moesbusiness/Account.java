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
    private String id;
    private boolean managerFlag = false;
    private ArrayList<String[]> shoppingCart;

    public Account() {} // Empty Constructor

    // Constructor for reading in customer accounts from file
    public Account(String username, String password, String id, String firstName,
                   String lastName, String stAddress, String city, String state, String zipCode)
    {
        this.username = username;
        this.password = password;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stAddress = stAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        shoppingCart = new ArrayList<String[]>(0);
    }

    // Constructor for reading in manager accounts from file
    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
        shoppingCart = new ArrayList<String[]>(0);
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
    public String getStAddress() {
        return stAddress;
    }
    public String getZipCode() {
        return zipCode;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    // END GETTERS AND SETTERS

    public void addToCart(String itemName, String itemAmount)
    {
        String[] itemAndQuantity = {itemName, itemAmount};
        shoppingCart.add(itemAndQuantity);
    }

    // Return the shopping cart for use
    public ArrayList<String[]> getShoppingCart()
    {
        return shoppingCart;
    }

    // Clear the shopping cart
    public void clearCart()
    {
        this.shoppingCart.clear();
    }
}
