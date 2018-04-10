package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class CustomerActivity extends Activity
{
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_customer layout will load the customer fragment that allows access to
        //  other fragments
        setContentView(R.layout.activity_customer);
    }

    // Show cart fragment
    public static void showCart()
    {

    }

    // Show customer the inventory
    public static void showInventory()
    {
        //Create fragment class object and set it to the right layout
        InventoryView inventoryView = new InventoryView();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, inventoryView)
                .addToBackStack(null)
                .commit();
    }

    // Show customer their past orders
    public static void showPastOrders()
    {

    }

    // Show customer's item view
    public static void showItem()
    {
        ManagerItemViewFragment itemView = new ManagerItemViewFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }
}
