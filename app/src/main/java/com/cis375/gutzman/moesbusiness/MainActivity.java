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
            while (fileInput.hasNextLine()) {
                fileLine = fileInput.nextLine();
                fileLine = fileLine.replace("\n", " ");
                String[] fileWords = fileLine.split(" ");

                Item temp = new Item
                        (fileWords[0],
                                Inventory.TheInventory.size() + 1,
                                Double.parseDouble(fileWords[1]),
                                Integer.parseInt(fileWords[2]),
                                Integer.parseInt(fileWords[3]));
                synchronized (Inventory.TheInventory) {
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
