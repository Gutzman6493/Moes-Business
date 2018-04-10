/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Customer view. From here the customer
        can interact with the business. Can interact by
        viewing shopping cart, viewing inventory sold by moes,
        view their past orders, and place an order.
*/
package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CustomerFragment extends Fragment
    implements View.OnClickListener
{

    private Button cartBtn;
    private Button itemBtn;
    private Button pastOrdersBtn;

    public CustomerFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get widgets for the variables
        cartBtn = (Button) view.findViewById(R.id.cartBtn);
        itemBtn = (Button) view.findViewById(R.id.itemBtn);
        pastOrdersBtn = (Button) view.findViewById(R.id.pastOrdersBtn);

        // Setup listeners
        cartBtn.setOnClickListener(this);
        itemBtn.setOnClickListener(this);
        pastOrdersBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.cartBtn:
                break;
            case R.id.itemBtn:
                CustomerActivity.showInventory();
                break;
            case R.id.pastOrdersBtn:
                break;
        }
    }
}
