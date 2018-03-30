/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Inventory class. Handles the inventory
        and whatever needs to happen to it
*/
/*
    FIXME CURRENT FIXMES:
    Determine everything that needs to happen to inventory
*/
package com.cis375.gutzman.moesbusiness;
import java.util.ArrayList;

public class Inventory
{
    static ArrayList<Item> TheInventory = new ArrayList<Item>(0);

    // Empty Constructor to give things access to inventory
    Inventory(){}

    public void addItemFromManager
    (String itemName, double itemCost, int itemReorderValue, int minOpAmount)
    {
        Item temp = new Item
        (
            itemName,
            TheInventory.size()+1,
            itemCost,
            itemReorderValue,
            minOpAmount
        );
        synchronized (TheInventory)
        {
            TheInventory.add(temp);
        }
    }
}
