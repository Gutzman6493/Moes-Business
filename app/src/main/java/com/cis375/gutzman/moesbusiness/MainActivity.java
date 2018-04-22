package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends Activity
{
    private static FragmentManager fragmentManager;
    private AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_main layout will load the login fragment that allows access to
        //  other fragments
        setContentView(R.layout.activity_main);

        // Attempt to make Scanner work for android (WORKS!) Only for assets (Readonly)
        assetManager = this.getAssets();
        loadFilledOrders();
        loadStatusReports();
        loadTodaysVendorShipment();
        loadAccounts();
        loadInventoryAssets();
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

    // Load default inventory
    public void loadInventoryAssets()
    {
        if(Inventory.TheInventory.isEmpty())
        {
            try
            {
                Scanner fileInput = new Scanner(assetManager.open("inventory.txt"));
                String fileLine;
                String fileLine2;
                while (fileInput.hasNextLine())
                {
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

                    Inventory.addItem(temp);

                }
                fileInput.close();

                // Now save to internal memory
                //saveInventoryInternal();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    // Load fulfilled orders text file
    public void loadFilledOrders()
    {
        if(AllFilledOrdersList.TheOrders.isEmpty())
        {
            try
            {
                Scanner fileInput = new Scanner(assetManager.open("fulfilledOrders.txt"));
                String fileLine;
                Order temp = new Order();
                int count = 0;
                while (fileInput.hasNextLine())
                {
                    fileLine = fileInput.nextLine();
                    fileLine = fileLine.replace("\n", " ");
                    String[] fileWords = fileLine.split(" ");

                    // if fileWords[0] == order that means you're reading the next order
                    if(fileWords[0].toUpperCase().equals("ORDER"))
                    {
                        if(count > AllFilledOrdersList.TheOrders.size())
                        {
                            AllFilledOrdersList.addOrder(temp);
                        }
                        count++;
                        temp = new Order
                                (
                                        fileWords[1],       // username
                                        fileWords[2],       // first name
                                        fileWords[3],       // last name
                                        fileWords[4],       // st address
                                        fileWords[5],       // city name
                                        fileWords[6],       // state name
                                        fileWords[7],       // zipcode
                                        fileWords[8],       // subtotal
                                        fileWords[9],       // total
                                        fileWords[10]       // orderID
                                );
                    }
                    // Else you're adding items bought info
                    else if(!fileLine.isEmpty() && !fileWords[0].equals("END"))
                    {
                        // ItemName, itemQuantity, itemCost, itemDiscountRate
                        temp.addItemOrdered(fileWords[0], fileWords[1], fileWords[2], fileWords[3]);
                    }
                    else if(fileWords[0].equals("END"))
                    {
                        AllFilledOrdersList.addOrder(temp);
                        return;
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    public void loadStatusReports()
    {
        if(StatusReports.TheReports.isEmpty())
        {
            try
            {
                Scanner fileInput = new Scanner(assetManager.open("statusreport.txt"));
                String fileLine;
                while (fileInput.hasNextLine())
                {
                    fileLine = fileInput.nextLine();
                    StatusReports.addReport(fileLine);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    public void loadTodaysVendorShipment()
    {
        if(AllVendorShipments.TheShipments.isEmpty())
        {
            try
            {
                Scanner fileInput = new Scanner(assetManager.open("todaysvendorshipment.txt"));
                String fileLine;
                while (fileInput.hasNextLine())
                {
                    fileLine = fileInput.nextLine();
                    fileLine = fileLine.replace("\n", " ");
                    String[] fileWords = fileLine.split(" ");

                    VendorShipment temp = new VendorShipment(fileWords[0], fileWords[1], fileWords[2], fileWords[3]);
                    AllVendorShipments.addShipment(temp);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void loadAccounts()
    {
        if(AllAccounts.TheAccounts.isEmpty())
        {
            try
            {
                Scanner fileInput = new Scanner(assetManager.open("AccountFile.txt"));
                String fileLine;
                while (fileInput.hasNextLine())
                {
                    fileLine = fileInput.nextLine();
                    fileLine = fileLine.replace("\n", " ");
                    String[] fileWords = fileLine.split(" ");

                    if(fileWords[0].equals("moe") || fileWords[0].equals("root") || fileWords[0].equals("admin"))
                    {
                        Account temp = new Account(fileWords[0], fileWords[1]);
                        temp.setManagerFlag(true);
                        AllAccounts.addAccount(temp);
                    }
                    else
                    {
                        Account temp = new Account(fileWords[0], fileWords[1], fileWords[2],
                                fileWords[3], fileWords[4], fileWords[5], fileWords[6], fileWords[7], fileWords[8]);
                        AllAccounts.addAccount(temp);
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
