/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Manager view. From here the manager
        can interact with the business. Can interact by
        viewing past orders, view inventory at warehouses
        or global inventory list, order resupply from vendors,

*/
package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ManagerFragment extends Fragment
    implements View.OnClickListener
{
    private Button inventoryBtn;
    private Button statusBtn;
    private Button batchBtn;

    public ManagerFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Assign widget variables
        inventoryBtn = (Button) view.findViewById(R.id.inventoryBtn);
        statusBtn = (Button) view.findViewById(R.id.statusBtn);
        batchBtn = (Button) view.findViewById(R.id.batchBtn);

        // Setup listeners
        inventoryBtn.setOnClickListener(this);
        statusBtn.setOnClickListener(this);
        batchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.inventoryBtn:
                ManagerActivity.showInventorySelection();
                break;
            case R.id.statusBtn:
                break;
            case R.id.batchBtn:
                break;
        }
    }
}
