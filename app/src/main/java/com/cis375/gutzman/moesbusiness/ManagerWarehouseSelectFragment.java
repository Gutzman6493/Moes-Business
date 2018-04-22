package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Context.MODE_PRIVATE;

public class ManagerWarehouseSelectFragment extends Fragment
    implements View.OnClickListener
{
    private Button wh1Btn;
    private Button wh2Btn;
    private Button wh3Btn;
    private Button wh4Btn;
    private Button wh5Btn;
    private Button wh6Btn;
    private Button wh7Btn;
    private Button wh8Btn;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public ManagerWarehouseSelectFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_warehouse_selection, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        wh1Btn = (Button) view.findViewById(R.id.wh1Btn);
        wh2Btn = (Button) view.findViewById(R.id.wh2Btn);
        wh3Btn = (Button) view.findViewById(R.id.wh3Btn);
        wh4Btn = (Button) view.findViewById(R.id.wh4Btn);
        wh5Btn = (Button) view.findViewById(R.id.wh5Btn);
        wh6Btn = (Button) view.findViewById(R.id.wh6Btn);
        wh7Btn = (Button) view.findViewById(R.id.wh7Btn);
        wh8Btn = (Button) view.findViewById(R.id.wh8Btn);

        wh1Btn.setOnClickListener(this);
        wh2Btn.setOnClickListener(this);
        wh3Btn.setOnClickListener(this);
        wh4Btn.setOnClickListener(this);
        wh5Btn.setOnClickListener(this);
        wh6Btn.setOnClickListener(this);
        wh7Btn.setOnClickListener(this);
        wh8Btn.setOnClickListener(this);

        // Setup Preferences
        prefs = this.getActivity().getSharedPreferences("preferences", MODE_PRIVATE);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.wh1Btn:
                editor = prefs.edit();
                editor.putInt("warehouseNum", 1);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
            case R.id.wh2Btn:
                editor = prefs.edit();
                editor.putInt("warehouseNum", 2);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
            case R.id.wh3Btn:
                editor = prefs.edit();
                editor.putInt("warehouseNum", 3);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
            case R.id.wh4Btn:
                editor = prefs.edit();
                editor.putInt("warehouseNum", 4);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
            case R.id.wh5Btn:
                editor = prefs.edit();
                editor.putInt("warehouseNum", 5);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
            case R.id.wh6Btn:editor = prefs.edit();
                editor.putInt("warehouseNum", 6);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
            case R.id.wh7Btn:
                editor = prefs.edit();
                editor.putInt("warehouseNum", 7);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
            case R.id.wh8Btn:
                editor = prefs.edit();
                editor.putInt("warehouseNum", 8);
                editor.commit();
                ManagerActivity.showNumWarehouseInv();
                break;
        }
    }
}
