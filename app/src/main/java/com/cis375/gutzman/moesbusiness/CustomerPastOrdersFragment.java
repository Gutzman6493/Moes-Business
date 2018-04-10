package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CustomerPastOrdersFragment  extends Fragment
{
    private ListView ordersList;

    public CustomerPastOrdersFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_past_order, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Assign widget variables
        ordersList = (ListView) view.findViewById(R.id.ordersList);

        /*
        for(int i = 0; i < Inventory.TheInventory.size(); i++)
        {
            test.add(Inventory.TheInventory.get(i).getItemName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, test);

        invList.setAdapter(adapter);
        */
    }
}
