package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;

public class CustomerActivity extends Activity
{
    private static FragmentManager fragmentManager;
    static Account customer;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_customer layout will load the customer fragment that allows access to
        //  other fragments
        setContentView(R.layout.activity_customer);

        // Setup Preferences
        prefs = getSharedPreferences("preferences", MODE_PRIVATE);

        // Get user's account
        customer = AllAccounts.getAccount(prefs.getString("Username", ""));
        customer.clearCart();
    }

    // Add an item to customers cart
    public static void addToTheirCart(String itemName, String itemAmount)
    {
        if(customer != null)
            customer.addToCart(itemName, itemAmount);
    }

    // Show cart fragment
    public static void showCart()
    {
        //Create fragment class object and set it to the right layout
        CustomerCartFragment itemView = new CustomerCartFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
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
        CustomerPastOrdersFragment itemView = new CustomerPastOrdersFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }

    // Show customer's item view
    public static void showItem()
    {
        CustomerItemViewFragment itemView = new CustomerItemViewFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }
    // Show customer's invoice
    public static void showInvoice(Fragment frag)
    {
        removeFrag(frag);
        CustomerInvoiceFragment itemView = new CustomerInvoiceFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }

    // Remove fragment
    public static void removeFrag(Fragment frag)
    {
        fragmentManager.beginTransaction()
                .remove(frag)
                .commit();
    }
}
