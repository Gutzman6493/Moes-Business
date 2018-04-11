package com.cis375.gutzman.moesbusiness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ManagerStatusReportFragment extends Fragment
{
    private ListView reportList;

    public ManagerStatusReportFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manager_status_report, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Assign widget variables
        reportList = (ListView) view.findViewById(R.id.reportList);


        ArrayList<String> temp = new ArrayList<String>(0);
        for(int i = 0; i < StatusReports.TheReports.size(); i++)
        {
            temp.add(StatusReports.TheReports.get(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, temp);

        reportList.setAdapter(adapter);
    }
}
