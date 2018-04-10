package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends Activity
{
    private static FragmentManager fragmentManager;
    private AssetManager assetManager;
    private boolean loadFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_main layout will load the login fragment that allows access to
        //  other fragments
        setContentView(R.layout.activity_main);

        // Attempt to make Scanner work for android (WORKS! Fuck yeah.) Only for assets (Readonly)
        if(fileExist("inventory.txt") && fileExist("AccountFile.txt"))
        {
            // If these files exist load them
            loadInventoryInternal();
            loadAccountsInternal();
        }
        if(loadFlag)
        {
            // else load default assets
            assetManager = this.getAssets();
            loadInventoryAssets();
            AllAccounts.addManagerAccounts();
            saveAccountsInternal();
        }

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
            saveInventoryInternal();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Save the default inventory to internal memory
    public void saveInventoryInternal()
    {
        String FILE_NAME = "inventory.txt";
        Context context = getApplication().getApplicationContext();
        try
        {
            OutputStreamWriter stream = new OutputStreamWriter(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE));
            String outputString = "";
            for(int i = 0; i < Inventory.TheInventory.size(); i++)
            {
                outputString = outputString.concat
                (
                    Inventory.TheInventory.get(i).getItemName() + " " +
                    Inventory.TheInventory.get(i).getCategory() + " " +
                    Inventory.TheInventory.get(i).getItemCost() + " " +
                    Inventory.TheInventory.get(i).getItemReorderValue() + " " +
                    Inventory.TheInventory.get(i).getMinOpAmount() + " " +
                    Inventory.TheInventory.get(i).getVendorName() + " " +
                    Inventory.TheInventory.get(i).getStockAmount(0) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(1) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(2) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(3) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(4) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(5) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(6) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(7) + " " +
                    Inventory.TheInventory.get(i).getStockAmount(8) + " \n" +
                    Inventory.TheInventory.get(i).getItemDesc() + " \n"
                );
            }
            stream.write(outputString);
            stream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    // Save default accounts to memory
    public void saveAccountsInternal()
    {
        String FILE_NAME = "AccountFile.txt";
        Context context = getApplication().getApplicationContext();
        try
        {
            OutputStreamWriter stream = new OutputStreamWriter(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE));
            String outputString = "";
            for(int i = 0; i < AllAccounts.TheAccounts.size(); i++)
            {
                outputString = outputString.concat
                (
                    AllAccounts.TheAccounts.get(i).getUsername() + " " +
                    AllAccounts.TheAccounts.get(i).getPassword() + "\n"
                );
            }
            stream.write(outputString);
            stream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Load updated inventory
    public void loadInventoryInternal()
    {
        String FILE_NAME = "inventory.txt";
        Context context = getApplication().getApplicationContext();
        try
        {
            InputStream inputStream = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bReader = new BufferedReader(inputStreamReader);
            String fileLine;
            String fileLine2;
            while ((fileLine = bReader.readLine()) != null)
            {
                fileLine2 = bReader.readLine();
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
            inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(Inventory.TheInventory.isEmpty())
            {
                Toast.makeText(getApplicationContext(),
                        "Inventory internal was empty",
                        Toast.LENGTH_SHORT).show();
                loadFlag = true;
            }

        }
    }
    // Load updated accounts
    public void loadAccountsInternal()
    {
        String FILE_NAME = "AccountFile.txt";
        Context context = getApplication().getApplicationContext();
        try
        {
            InputStream inputStream = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bReader = new BufferedReader(inputStreamReader);
            String fileLine;
            while ((fileLine = bReader.readLine()) != null)
            {
                fileLine = fileLine.replace("\n", " ");
                String[] fileWords = fileLine.split(" ");
                Account temp = new Account(fileWords[0], fileWords[1]);
                if ((fileWords[0].equals("moe")) || (fileWords[0].equals("root")) || (fileWords[0].equals("admin")))
                {
                    temp.setManagerFlag(true);
                }
                AllAccounts.addAccount(temp);
            }
            inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(AllAccounts.TheAccounts.isEmpty())
            {
                Toast.makeText(getApplicationContext(),
                        "Accounts internal was empty",
                        Toast.LENGTH_SHORT).show();
                loadFlag = true;
            }

        }
    }

    // Used to check if the file exist
    public boolean fileExist(String fname)
    {
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }

    // FIXME will be used to run batch files
    public static void runBatchFiles()
    {
        // Order of inputs
        // Vendor incoming, Fulfillment of Backlog Orders
        // Today's orders, Vendor Outgoing
    }
}
