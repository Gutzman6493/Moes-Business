/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Order class. Creates the Order to send
        to appropriate things to handle order fulfillment.
*/
/*
    FIXME CURRENT FIXMES:
    Determine everything that needs to happen to orders
*/

package com.cis375.gutzman.moesbusiness;

import java.util.ArrayList;

public class Order
{
    private String username;
    private String firstName;
    private String lastName;
    private String stAddress;
    private String cityName;
    private String stateName;
    private String zipcode;
    private String subtotal;
    private String total;
    ArrayList<String[]> purchasedItems;

    Order()
    {
        purchasedItems = new ArrayList<String[]>(0);
    } // Empty Constructor

    Order(String username, String firstName, String lastName,
          String stAddress, String cityName, String stateName, String zipcode,
          String subtotal, String total)
    {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stAddress = stAddress;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipcode = zipcode;
        this.subtotal = subtotal;
        this.total = total;
        purchasedItems = new ArrayList<String[]>(0);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStAddress() {
        return stAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public String getTotal() {
        return total;
    }

    public ArrayList<String[]> getPurchasedItems() {
        return purchasedItems;
    }

    public void addItemOrdered(String itemName, String itemQuantity, String itemCost)
    {
        String[] boughtItem = {itemName, itemQuantity, itemCost};
        purchasedItems.add(boughtItem);
    }
}
