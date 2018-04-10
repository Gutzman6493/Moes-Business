package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class CustomerItemViewFragment extends Fragment
    implements View.OnClickListener
{
    private ListView itemList;
    private Button addToCartBtn;
    private EditText amountTxt;
    private TextView itemName;
    private TextView itemCost;
    private TextView globalInv;
    private TextView itemDesc;
    private TextView backorderFlag;
    private TextView category;

    private int itemIndex;
    private SharedPreferences prefs;
    private Item temp;

    public CustomerItemViewFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_view_customer, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Setup Preferences
        prefs = this.getActivity().getSharedPreferences("preferences", MODE_PRIVATE);
        itemIndex = prefs.getInt("itemIndex", 0);

        // Assign widget variables
        itemName = (TextView) view.findViewById(R.id.itemName);
        itemCost = (TextView) view.findViewById(R.id.itemCost);
        globalInv = (TextView) view.findViewById(R.id.globalInv);
        backorderFlag = (TextView) view.findViewById(R.id.backorderFlag);
        category = (TextView) view.findViewById(R.id.category);
        itemDesc = (TextView) view.findViewById(R.id.itemDesc);
        itemList = (ListView) view.findViewById(R.id.itemList);
        addToCartBtn = (Button) view.findViewById(R.id.addToCartBtn);
        amountTxt = (EditText) view.findViewById(R.id.amountTxt);

        // Set onClick listeners
        addToCartBtn.setOnClickListener(this);
        amountTxt.setOnClickListener(this);

        // Pull necessary info from inventory
        temp = Inventory.TheInventory.get(itemIndex);
        itemName.setText(temp.getItemName());
        itemCost.setText("$" + String.valueOf(temp.getItemCost()));
        globalInv.setText(String.valueOf(temp.getStockAmount(0)));
        itemDesc.setText(temp.getItemDesc());
        backorderFlag.setText(String.valueOf(temp.getBackOrderFlag()));
        category.setText(temp.getCategory());

        ArrayList tempList = new ArrayList<String>(0);
        for(int i = 0; i < Inventory.TheInventory.size(); i++)
        {
            if(Inventory.TheInventory.get(i).getCategory().equals(temp.getCategory()))
            {
                tempList.add(Inventory.TheInventory.get(i).getItemName());
            }

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, tempList);

        itemList.setAdapter(adapter);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.amountTxt:
                amountTxt.setText("");
                break;
            case R.id.addToCartBtn:
                if(!amountTxt.getText().toString().isEmpty() && Integer.parseInt(amountTxt.getText().toString()) > 0)
                {
                    Toast.makeText(this.getActivity().getApplicationContext(),
                            "Item added to cart",
                            Toast.LENGTH_SHORT).show();
                    CustomerActivity.addToTheirCart(temp.getItemName(), amountTxt.getText().toString());
                }
                else
                {
                    Toast.makeText(this.getActivity().getApplicationContext(),
                            "Please enter a valid amount",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
