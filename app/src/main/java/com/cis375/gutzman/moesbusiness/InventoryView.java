/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: InventoryView class. Handles displaying the
    inventory in the app
*/
/*
    FIXME CURRENT FIXMES:
    Determine everything that needs to happen to inventory
*/
package com.cis375.gutzman.moesbusiness;

import android.app.ListFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class InventoryView extends ListFragment
    implements AdapterView.OnItemClickListener
{
    private ListView invList;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public InventoryView(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        invList = (ListView) view.findViewById(R.id.invList);
        ArrayList test = new ArrayList<String>(0);
        for(int i = 0; i < Inventory.TheInventory.size(); i++)
        {
            test.add(Inventory.TheInventory.get(i).getItemName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, test);

        invList.setAdapter(adapter);
        invList.setOnItemClickListener(this);

        // Setup Preferences
        prefs = this.getActivity().getSharedPreferences("preferences", MODE_PRIVATE);
    }

        @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        // Load Item layout, once in item layout get that item's info for the
        // widgets to use so we don't need to make multiple layouts
        editor = prefs.edit();
        editor.putInt("itemIndex", i);
        editor.commit();

        if (AllAccounts.checkManagerFlag(prefs.getString("Username", "")))
        {
            ManagerActivity.showItem();
        }
        else
        {
            CustomerActivity.showItem();
        }
    }
}
