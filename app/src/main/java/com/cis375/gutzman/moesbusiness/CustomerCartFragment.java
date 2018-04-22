package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerCartFragment extends Fragment
    implements View.OnClickListener
{
    private ListView itemList;
    private Button checkOutBtn;
    private TextView subtotalText;
    private TextView totalText;
    private double subTotal;
    private double total;

    public CustomerCartFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_cart, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        subTotal = 0;
        total = 0;

        // Assign widget variables
        itemList = (ListView) view.findViewById(R.id.itemList);
        checkOutBtn = (Button) view.findViewById(R.id.checkOutBtn);
        subtotalText = (TextView) view.findViewById(R.id.subtotalText);
        totalText = (TextView) view.findViewById(R.id.totalText);

        // Setup listeners
        checkOutBtn.setOnClickListener(this);

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
        total = subTotal + (subTotal * .06);
        subtotalText.setText("Subtotal: $" + subTotal);
        totalText.setText("Total: $" + total);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.checkOutBtn:
                if(CustomerActivity.customer.getShoppingCart().isEmpty())
                {
                    Toast.makeText(this.getActivity().getApplicationContext(),
                            "Your cart is empty. Please add items to buy them",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    CustomerActivity.showInvoice(this);
                }
                break;
        }
    }
}
