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
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory
{
    static ArrayList<Item> TheInventory = new ArrayList<Item>(0);

    // Empty Constructor to give things access to inventory
    Inventory(){}

    public void addItemsFromFile()
    {
        File inventoryFile = new File("inventory.txt");
        String fileLine;
        try
        {
            Scanner fileInput = new Scanner(inventoryFile);
            while (fileInput.hasNextLine())
            {
                fileLine = fileInput.nextLine();
                fileLine = fileLine.replace("\n", " ");
                String[] fileWords = fileLine.split(" ");

                Item temp = new Item
                        (fileWords[0],
                        TheInventory.size()+1,
                        Double.parseDouble(fileWords[1]),
                        Integer.parseInt(fileWords[2]),
                        Integer.parseInt(fileWords[3]));
                synchronized (TheInventory)
                {
                    TheInventory.add(temp);
                }

            }
            fileInput.close();
        }
        catch(FileNotFoundException e)
        {
        }
    }

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
