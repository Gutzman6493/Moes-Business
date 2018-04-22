package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ManagerVendorShipmentFragment extends Fragment
{
    ListView orderList;

    public ManagerVendorShipmentFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_vendor_shipments, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        orderList = (ListView) view.findViewById(R.id.orderList);

        ArrayList tempList = new ArrayList<String>(0);
        String tempString;
        for(int i = 0; i < AllVendorShipments.TheShipments.size(); i++)
        {
            tempString = AllVendorShipments.TheShipments.get(i).getVendorId() + " " +
                         AllVendorShipments.TheShipments.get(i).getVendorName() + "\n" +
                         AllVendorShipments.TheShipments.get(i).getItemName() + " x " +
                         AllVendorShipments.TheShipments.get(i).getItemAmt();
            tempList.add(tempString);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, tempList);

        orderList.setAdapter(adapter);
    }
}
