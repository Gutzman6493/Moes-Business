package com.cis375.gutzman.moesbusiness;

import java.util.ArrayList;

public class AllFilledOrdersList
{
    static ArrayList<Order> TheOrders = new ArrayList<Order>(0);

    public static void addOrder(Order theOrder)
    {
        synchronized (TheOrders)
        {
            TheOrders.add(theOrder);
        }
    }
}
