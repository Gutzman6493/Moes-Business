package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class CustomerActivity extends Activity
{
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_customer layout will load the customer fragment that allows access to
        //  other fragments
        //setContentView(R.layout.activity_main);
    }
}
