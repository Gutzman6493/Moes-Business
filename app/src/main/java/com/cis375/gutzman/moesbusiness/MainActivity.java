package com.cis375.gutzman.moesbusiness;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity
{
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Assign layout and fragmentManager
        fragmentManager = getFragmentManager();
        // activity_main layout will load the login fragment that allows access to
        //  other fragments
        setContentView(R.layout.activity_main);
    }

    public static void showForgot()
    {
        //Create fragment class object and set it to the right layout
        ForgotFragment forgotFrag = new ForgotFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, forgotFrag)
                .addToBackStack(null)
                .commit();
    }
    public static void showCreateAccount()
    {
        //Create fragment class object and set it to the right layout
        CreateAccountFragment createFrag = new CreateAccountFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, createFrag)
                .addToBackStack(null)
                .commit();
    }

    public static void removeFrag(Fragment frag)
    {
        fragmentManager.beginTransaction()
                .remove(frag)
                .commit();
    }
}
