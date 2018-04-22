package com.cis375.gutzman.moesbusiness;

import java.util.ArrayList;

public class AllVendorShipments
{
    static ArrayList<VendorShipment> TheShipments = new ArrayList<VendorShipment>(0);

    // Adds shipment to the list of shipments for today
    public static void addShipment(VendorShipment vs)
    {
        synchronized (TheShipments)
        {
            TheShipments.add(vs);
        }
    }
}
