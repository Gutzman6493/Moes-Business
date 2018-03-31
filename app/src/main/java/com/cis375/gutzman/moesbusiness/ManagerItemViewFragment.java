/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Item view class for manager. Shows all info on
        a item.
*/
package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class ManagerItemViewFragment extends Fragment
{
    private TextView itemName;
    private TextView itemId;
    private TextView itemCost;
    private TextView globalInv;
    private TextView wh1Inv;
    private TextView wh2Inv;
    private TextView wh3Inv;
    private TextView wh4Inv;
    private TextView wh5Inv;
    private TextView wh6Inv;
    private TextView wh7Inv;
    private TextView wh8Inv;
    private TextView reorderNum;
    private TextView vendorName;
    private TextView itemDesc;

    private int itemIndex;
    private SharedPreferences prefs;

    public ManagerItemViewFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_view_manager, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Setup Preferences
        prefs = this.getActivity().getSharedPreferences("preferences", MODE_PRIVATE);
        itemIndex = prefs.getInt("itemIndex", 0);

        // Assign widget variables
        itemName = (TextView) view.findViewById(R.id.itemName);
        itemId = (TextView) view.findViewById(R.id.itemId);
        itemCost = (TextView) view.findViewById(R.id.itemCost);
        globalInv = (TextView) view.findViewById(R.id.globalInv);
        wh1Inv = (TextView) view.findViewById(R.id.wh1Inv);
        wh2Inv = (TextView) view.findViewById(R.id.wh2Inv);
        wh3Inv = (TextView) view.findViewById(R.id.wh3Inv);
        wh4Inv = (TextView) view.findViewById(R.id.wh4Inv);
        wh5Inv = (TextView) view.findViewById(R.id.wh5Inv);
        wh6Inv = (TextView) view.findViewById(R.id.wh6Inv);
        wh7Inv = (TextView) view.findViewById(R.id.wh7Inv);
        wh8Inv = (TextView) view.findViewById(R.id.wh8Inv);
        reorderNum = (TextView) view.findViewById(R.id.reorderNum);
        vendorName = (TextView) view.findViewById(R.id.vendorName);
        itemDesc = (TextView) view.findViewById(R.id.itemDesc);

        // Pull necessary info from inventory
        Item temp = Inventory.TheInventory.get(itemIndex);
        itemName.setText(temp.getItemName());
        itemId.setText(String.valueOf(temp.getItemId()));
        itemCost.setText("$" + String.valueOf(temp.getItemCost()));
        globalInv.setText(String.valueOf(temp.getStockAmount(0)));
        wh1Inv.setText(String.valueOf(temp.getStockAmount(1)));
        wh2Inv.setText(String.valueOf(temp.getStockAmount(2)));
        wh3Inv.setText(String.valueOf(temp.getStockAmount(3)));
        wh4Inv.setText(String.valueOf(temp.getStockAmount(4)));
        wh5Inv.setText(String.valueOf(temp.getStockAmount(5)));
        wh6Inv.setText(String.valueOf(temp.getStockAmount(6)));
        wh7Inv.setText(String.valueOf(temp.getStockAmount(7)));
        wh8Inv.setText(String.valueOf(temp.getStockAmount(8)));
        reorderNum.setText(String.valueOf(temp.getItemReorderValue()));
        vendorName.setText(temp.getVendorName()); // FIXME update when vendors are made
        itemDesc.setText(temp.getItemDesc());
    }
}
