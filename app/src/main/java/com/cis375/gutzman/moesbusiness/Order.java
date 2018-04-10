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
    ArrayList<String[]> purchasedItems;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStAddress() {
        return stAddress;
    }

    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
