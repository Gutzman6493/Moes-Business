package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ManagerInvSelectionFragment extends Fragment
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
    private Button globalBtn;

    public ManagerInvSelectionFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory_selection, container, false);
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
        globalBtn = (Button) view.findViewById(R.id.globalBtn);

        wh1Btn.setOnClickListener(this);
        wh2Btn.setOnClickListener(this);
        wh3Btn.setOnClickListener(this);
        wh4Btn.setOnClickListener(this);
        wh5Btn.setOnClickListener(this);
        wh6Btn.setOnClickListener(this);
        wh7Btn.setOnClickListener(this);
        wh8Btn.setOnClickListener(this);
        globalBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.wh1Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.wh2Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.wh3Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.wh4Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.wh5Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.wh6Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.wh7Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.wh8Btn:
                ManagerActivity.showInventory(1);
                break;
            case R.id.globalBtn:
                ManagerActivity.showInventory(1);
                break;
        }
    }
}
