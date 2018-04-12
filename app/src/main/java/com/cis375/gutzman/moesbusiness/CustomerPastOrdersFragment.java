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

public class CustomerPastOrdersFragment  extends Fragment
{
    private ListView ordersList;
    private SharedPreferences prefs;

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

        // Setup Preferences
        prefs = this.getActivity().getSharedPreferences("preferences", MODE_PRIVATE);

        String username = prefs.getString("Username", "");

        ArrayList<String> temp = new ArrayList<String>(0);
        ArrayList<String[]> items;
        String itemString = "";
        for(int i = 0; i < AllFilledOrdersList.TheOrders.size(); i++)
        {
            if(AllFilledOrdersList.TheOrders.get(i).getUsername().equals(username))
            {
                items = AllFilledOrdersList.TheOrders.get(i).getPurchasedItems();
                itemString = itemString.concat(AllFilledOrdersList.TheOrders.get(i).getOrderId() + "\n");
                for(int j = 0; j < items.size(); j++)
                {
                    itemString = itemString.concat(items.get(j)[0] + " x " + items.get(j)[1] + " = " + items.get(j)[2] + " - Sale %: " +
                                                    items.get(j)[3] + "%\n");
                }
                temp.add(itemString);
                itemString = "";
            }

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, temp);

        ordersList.setAdapter(adapter);

    }
}
