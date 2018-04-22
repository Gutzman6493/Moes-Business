package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class ManagerActivity extends Activity
{
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_customer layout will load the manager fragment that allows access to
        //  other fragments
        setContentView(R.layout.activity_manager);
    }

    public static void showInventory()
    {
        //Create fragment class object and set it to the right layout
        InventoryView inventoryView = new InventoryView();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, inventoryView)
                .addToBackStack(null)
                .commit();
    }

    public static void showItem()
    {
        ManagerItemViewFragment itemView = new ManagerItemViewFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }

    public static void showPastOrders()
    {
        ManagerPastOrdersFragment itemView = new ManagerPastOrdersFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }

    public static void showStatusReport()
    {
        ManagerStatusReportFragment itemView = new ManagerStatusReportFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }

    public static void showVendorShipments()
    {
        ManagerVendorShipmentFragment itemView = new ManagerVendorShipmentFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }

    public static void showWarehouseSelection()
    {
        ManagerWarehouseSelectFragment itemView = new ManagerWarehouseSelectFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }

    public static void showNumWarehouseInv()
    {
        ManagerWarehouseInventoryFragment itemView = new ManagerWarehouseInventoryFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, itemView)
                .addToBackStack(null)
                .commit();
    }
}
