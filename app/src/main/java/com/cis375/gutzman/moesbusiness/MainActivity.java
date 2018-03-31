package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends Activity {
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_main layout will load the login fragment that allows access to
        //  other fragments
        setContentView(R.layout.activity_main);

        // Attempt to make Scanner work for android (WORKS! Fuck yeah.)
        loadInventory();
    }

    public static void showForgot() {
        //Create fragment class object and set it to the right layout
        ForgotFragment forgotFrag = new ForgotFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, forgotFrag)
                .addToBackStack(null)
                .commit();
    }

    public static void showCreateAccount() {
        //Create fragment class object and set it to the right layout
        CreateAccountFragment createFrag = new CreateAccountFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, createFrag)
                .addToBackStack(null)
                .commit();
    }

    public static void removeFrag(Fragment frag) {
        fragmentManager.beginTransaction()
                .remove(frag)
                .commit();
    }

    public void loadInventory()
    {
        try {
            Scanner fileInput = new Scanner(getAssets().open("inventory.txt"));
            String fileLine;
            String fileLine2;
            while (fileInput.hasNextLine()) {
                fileLine = fileInput.nextLine();
                fileLine2 = fileInput.nextLine(); // This will get the Item Desc since it's on its own line
                fileLine = fileLine.replace("\n", " ");
                String[] fileWords = fileLine.split(" ");

                Item temp = new Item
                        (fileWords[0], // itemName
                        fileWords[1],  // itemCategory
                        Inventory.TheInventory.size(),    // itemId (will change if inventory changes)
                        Double.parseDouble(fileWords[2]), // itemCost
                        Integer.parseInt(fileWords[3]),   // reorderValue
                        Integer.parseInt(fileWords[4]),   // minOpAmount
                        fileWords[5],                     // vendorName
                        Long.parseLong(fileWords[6]),     // globalInv#
                        Long.parseLong(fileWords[7]),     // wh1Inv#
                        Long.parseLong(fileWords[8]),     // wh2Inv#
                        Long.parseLong(fileWords[9]),     // wh3Inv#
                        Long.parseLong(fileWords[10]),     // wh4Inv#
                        Long.parseLong(fileWords[11]),     // wh5Inv#
                        Long.parseLong(fileWords[12]),     // wh6Inv#
                        Long.parseLong(fileWords[13]),     // wh7Inv#
                        Long.parseLong(fileWords[14]),     // wh8Inv#
                        fileLine2);
                synchronized (Inventory.TheInventory)
                {
                    Inventory.TheInventory.add(temp);
                }

            }
            fileInput.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void runBatchFiles()
    {
        // Order of inputs
        // Vendor incoming, Fulfillment of Backlog Orders
        // Today's orders, Vendor Outgoing
    }
}
