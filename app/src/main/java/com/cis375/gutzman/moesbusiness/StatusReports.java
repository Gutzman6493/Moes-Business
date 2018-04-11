package com.cis375.gutzman.moesbusiness;

import java.util.ArrayList;

public class StatusReports
{
    static ArrayList<String> TheReports = new ArrayList<String>(0);

    public static void addReport(String report)
    {
        synchronized (TheReports)
        {
            TheReports.add(report);
        }
    }
}
