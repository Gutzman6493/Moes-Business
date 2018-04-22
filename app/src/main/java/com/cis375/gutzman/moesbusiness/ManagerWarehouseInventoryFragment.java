package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ManagerWarehouseInventoryFragment extends Fragment
{
    private ListView itemList;
    private SharedPreferences prefs;
    private int index;

    public ManagerWarehouseInventoryFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_warehouse_inv, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Setup Preferences
        prefs = this.getActivity().getSharedPreferences("preferences", MODE_PRIVATE);
        index = prefs.getInt("warehouseNum", 1);

        itemList = (ListView) view.findViewById(R.id.itemList);

        ArrayList tempList = new ArrayList<String>(0);
        String tempString;
        for(int i = 0; i < Inventory.TheInventory.size(); i++)
        {
            tempString = Inventory.TheInventory.get(i).getItemName() + " x " +
                         Inventory.TheInventory.get(i).getStockAmount(index);
            tempList.add(tempString);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, tempList);

        itemList.setAdapter(adapter);
    }
}
