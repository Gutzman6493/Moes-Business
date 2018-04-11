package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagerPastOrdersFragment extends Fragment
    implements View.OnClickListener
{
    private ListView ordersList;
    private EditText firstNameTxt;
    private Button searchFirstBtn;
    private EditText lastNameTxt;
    private Button searchLastBtn;
    private EditText itemNameTxt;
    private Button searchItemBtn;
    private EditText itemAmtTxt;
    private Button searchAmtBtn;
    private Button showAllBtn;

    public ManagerPastOrdersFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_past_order, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Assign widget variables
        ordersList = (ListView) view.findViewById(R.id.ordersList);
        firstNameTxt = (EditText) view.findViewById(R.id.firstNameTxt);
        searchFirstBtn = (Button) view.findViewById(R.id.searchFirstBtn);
        lastNameTxt = (EditText) view.findViewById(R.id.lastNameTxt);
        searchLastBtn = (Button) view.findViewById(R.id.searchLastBtn);
        itemNameTxt = (EditText) view.findViewById(R.id.itemNameTxt);
        searchItemBtn = (Button) view.findViewById(R.id.searchItemBtn);
        itemAmtTxt = (EditText) view.findViewById(R.id.itemAmtTxt);
        searchAmtBtn = (Button) view.findViewById(R.id.searchAmtBtn);
        showAllBtn = (Button) view.findViewById(R.id.showAllBtn);

        // Setup listeners
        firstNameTxt.setOnClickListener(this);
        searchFirstBtn.setOnClickListener(this);
        lastNameTxt.setOnClickListener(this);
        searchLastBtn.setOnClickListener(this);
        itemNameTxt.setOnClickListener(this);
        searchItemBtn.setOnClickListener(this);
        itemAmtTxt.setOnClickListener(this);
        searchAmtBtn.setOnClickListener(this);
        showAllBtn.setOnClickListener(this);

        handleAll();
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.firstNameText:
                firstNameTxt.setText("");
                break;
            case R.id.searchFirstBtn:
                handleFirst();
                break;
            case R.id.lastNameTxt:
                lastNameTxt.setText("");
                break;
            case R.id.searchLastBtn:
                handleLast();
                break;
            case R.id.itemNameTxt:
                itemNameTxt.setText("");
                break;
            case R.id.searchItemBtn:
                handleItem();
                break;
            case R.id.itemAmtTxt:
                itemAmtTxt.setText("");
                break;
            case R.id.searchAmtBtn:
                handleAmt();
                break;
            case R.id.showAllBtn:
                handleAll();
                break;
        }
    }

    public void handleFirst()
    {
        ArrayList<String> temp = new ArrayList<String>(0);
        ArrayList<String[]> items;
        String firstName = firstNameTxt.getText().toString();
        if(firstName.isEmpty())
        {
            Toast.makeText(this.getActivity().getApplicationContext(),
                    "Please enter a first name",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        firstName = firstName.toUpperCase();
        String itemString = "";
        for(int i = 0; i < AllFilledOrdersList.TheOrders.size(); i++)
        {
            if(AllFilledOrdersList.TheOrders.get(i).getFirstName().toUpperCase().equals(firstName))
            {
                items = AllFilledOrdersList.TheOrders.get(i).getPurchasedItems();
                itemString = itemString.concat(AllFilledOrdersList.TheOrders.get(i).getFirstName() + " " +
                                                AllFilledOrdersList.TheOrders.get(i).getLastName() + " " +
                                                AllFilledOrdersList.TheOrders.get(i).getTotal() + "\n");
                for(int j = 0; j < items.size(); j++)
                {
                    itemString = itemString.concat(items.get(j)[0] + " x " + items.get(j)[1] + " = " + items.get(j)[2] + "\n");
                }
                temp.add(itemString);
                itemString = "";
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, temp);

        ordersList.setAdapter(adapter);

    }
    public void handleLast()
    {
        ArrayList<String> temp = new ArrayList<String>(0);
        ArrayList<String[]> items;
        String lastName = lastNameTxt.getText().toString();
        if(lastName.isEmpty())
        {
            Toast.makeText(this.getActivity().getApplicationContext(),
                    "Please enter a last name",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        lastName = lastName.toUpperCase();
        String itemString = "";
        for(int i = 0; i < AllFilledOrdersList.TheOrders.size(); i++)
        {
            if(AllFilledOrdersList.TheOrders.get(i).getLastName().toUpperCase().equals(lastName))
            {
                items = AllFilledOrdersList.TheOrders.get(i).getPurchasedItems();
                itemString = itemString.concat(AllFilledOrdersList.TheOrders.get(i).getFirstName() + " " +
                                                AllFilledOrdersList.TheOrders.get(i).getLastName() + " " +
                                                AllFilledOrdersList.TheOrders.get(i).getTotal() + "\n");
                for(int j = 0; j < items.size(); j++)
                {
                    itemString = itemString.concat(items.get(j)[0] + " x " + items.get(j)[1] + " = " + items.get(j)[2] + "\n");
                }
                temp.add(itemString);
                itemString = "";
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, temp);

        ordersList.setAdapter(adapter);
    }
    public void handleItem()
    {
        ArrayList<String> temp = new ArrayList<String>(0);
        ArrayList<String[]> items;
        boolean found = false;
        String itemName = itemNameTxt.getText().toString();
        if(itemName.isEmpty())
        {
            Toast.makeText(this.getActivity().getApplicationContext(),
                    "Please enter a item name",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        itemName = itemName.toUpperCase();
        String itemString = "";
        for(int i = 0; i < AllFilledOrdersList.TheOrders.size(); i++)
        {
            items = AllFilledOrdersList.TheOrders.get(i).getPurchasedItems();
            for(int j = 0; j < items.size(); j++)
            {
                if(items.get(j)[0].toUpperCase().equals(itemName))
                {
                    found = true;
                    break;
                }
            }
            if(found)
            {
                itemString = itemString.concat(AllFilledOrdersList.TheOrders.get(i).getFirstName() + " " +
                        AllFilledOrdersList.TheOrders.get(i).getLastName() + " " +
                        AllFilledOrdersList.TheOrders.get(i).getTotal() + "\n");

                for(int k = 0; k < items.size(); k++)
                {
                    itemString = itemString.concat(items.get(k)[0] + " x " + items.get(k)[1] + " = " + items.get(k)[2] + "\n");
                }
                temp.add(itemString);
                itemString = "";
                found = false;
            }

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, temp);

        ordersList.setAdapter(adapter);
    }
    public void handleAmt()
    {
        ArrayList<String> temp = new ArrayList<String>(0);
        ArrayList<String[]> items;
        boolean found = false;
        String itemAmt = itemAmtTxt.getText().toString();
        if(itemAmt.isEmpty())
        {
            Toast.makeText(this.getActivity().getApplicationContext(),
                    "Please enter a item amount",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String itemString = "";
        for(int i = 0; i < AllFilledOrdersList.TheOrders.size(); i++)
        {
            items = AllFilledOrdersList.TheOrders.get(i).getPurchasedItems();
            for(int j = 0; j < items.size(); j++)
            {
                if(items.get(j)[1].equals(itemAmt))
                {
                    found = true;
                    break;
                }
            }
            if(found)
            {
                itemString = itemString.concat(AllFilledOrdersList.TheOrders.get(i).getFirstName() + " " +
                        AllFilledOrdersList.TheOrders.get(i).getLastName() + " " +
                        AllFilledOrdersList.TheOrders.get(i).getTotal() + "\n");

                for(int k = 0; k < items.size(); k++)
                {
                    itemString = itemString.concat(items.get(k)[0] + " x " + items.get(k)[1] + " = " + items.get(k)[2] + "\n");
                }
                temp.add(itemString);
                itemString = "";
                found = false;
            }

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, temp);

        ordersList.setAdapter(adapter);
    }
    public void handleAll()
    {
        ArrayList<String> temp = new ArrayList<String>(0);
        ArrayList<String[]> items;
        String itemString = "";
        for(int i = 0; i < AllFilledOrdersList.TheOrders.size(); i++)
        {
            itemString = itemString.concat(AllFilledOrdersList.TheOrders.get(i).getFirstName() + " " +
                    AllFilledOrdersList.TheOrders.get(i).getLastName() + " " +
                    AllFilledOrdersList.TheOrders.get(i).getTotal() + "\n");
            items = AllFilledOrdersList.TheOrders.get(i).getPurchasedItems();
            for(int j = 0; j < items.size(); j++)
            {
                itemString = itemString.concat(items.get(j)[0] + " x " + items.get(j)[1] + " = " + items.get(j)[2] + "\n");
            }
            temp.add(itemString);
            itemString = "";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, temp);

        ordersList.setAdapter(adapter);
    }

}
