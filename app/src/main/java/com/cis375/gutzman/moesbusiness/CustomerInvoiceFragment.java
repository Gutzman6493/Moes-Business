package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerInvoiceFragment extends Fragment
{
    private ListView itemList;
    private TextView name;
    private TextView stAddress;
    private TextView city;
    private TextView state;
    private TextView zipcode;
    private TextView subtotal;
    private TextView total;

    public CustomerInvoiceFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_invoice, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Assign widget variables
        itemList = (ListView) view.findViewById(R.id.itemList);
        name = (TextView) view.findViewById(R.id.name);
        stAddress = (TextView) view.findViewById(R.id.stAddress);
        city =  (TextView) view.findViewById(R.id.city);
        state = (TextView) view.findViewById(R.id.state);
        zipcode = (TextView) view.findViewById(R.id.zipcode);
        subtotal = (TextView) view.findViewById(R.id.subtotal);
        total =  (TextView) view.findViewById(R.id.total);

        double subTotal = 0;
        double totalNum = 0;

        // Fill up with list with shopping cart
        ArrayList<String[]> theCart = CustomerActivity.customer.getShoppingCart();
        ArrayList tempList = new ArrayList<String>(0);
        for(int j = 0; j < theCart.size(); j++)
        {
            for(int i = 0; i < Inventory.TheInventory.size(); i++)
            {
                if(Inventory.TheInventory.get(i).getItemName().equals(theCart.get(j)[0]))
                {

                    subTotal += (Inventory.TheInventory.get(i).getItemCost() * Integer.parseInt(theCart.get(j)[1]));
                    tempList.add(Inventory.TheInventory.get(i).getItemName() + " Quantity: " +
                            theCart.get(j)[1]);
                }
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, tempList);

        itemList.setAdapter(adapter);
        totalNum = subTotal + (subTotal * .06);

        // Set the text fields
        subtotal.setText("$" + subTotal);
        total.setText("$" + totalNum);
        name.setText(CustomerActivity.customer.getFirstName() + " " + CustomerActivity.customer.getLastName());
        stAddress.setText(CustomerActivity.customer.getStAddress());
        city.setText(CustomerActivity.customer.getCity());
        state.setText(CustomerActivity.customer.getState());
        zipcode.setText(CustomerActivity.customer.getZipCode());

        // Tell the user their order is being processed
        Toast.makeText(this.getActivity().getApplicationContext(),
                "Your order has been submitted and is being processed",
                Toast.LENGTH_SHORT).show();

        // and clear their cart
        CustomerActivity.customer.clearCart();
    }
}
