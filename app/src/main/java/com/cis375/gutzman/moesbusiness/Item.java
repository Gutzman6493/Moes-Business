/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Item class. Holds all info for each
        individual item.
*/
/*
    FIXME CURRENT FIXMES:
    Handle Vendors
    Create setters for necessary variables
*/
package com.cis375.gutzman.moesbusiness;

public class Item
{
    // Variables for each Item
    private int itemId;
    private String itemName;
    private String itemDesc;
    private double itemCost;
    private long[] itemStock; // index: 0 = Global 1-8 = Warehouse# Stock
    private int itemReorderValue;
    private double promotionalRate; // EXTRA
    private int minOpAmount;
    //private Vendor itemSeller;
    //private double[] itemFreq; // Frequencies for how much each warehouse sells EXTRA
    private boolean backOrderFlag = false;

    // Constructor - Must have necessary info before constructing
    Item(String itemName, int itemId, double itemCost, int itemReorderValue, int minOpAmount)
    //FIXME ADD VENDOR INFO WHEN VENDOR CLASS IS MADE
    {
        this.itemName = itemName;
        this.itemDesc = "";
        this.itemId = itemId;
        this.promotionalRate = 0.0;
        this.itemCost = itemCost;
        this.itemReorderValue = itemReorderValue;
        this.minOpAmount = minOpAmount;
        itemStock = new long[9];
        //itemFreq = new double[8];
    }
    public double getItemCost()
    {
        return itemCost;
    }
    public int getItemReorderValue()
    {
        return itemReorderValue;
    }
    public int getMinOpAmount()
    {
        return minOpAmount;
    }
    public String getItemName()
    {
        return itemName;
    }
    public String getItemDesc()
    {
        return itemDesc;
    }
    public double getPromotionalRate()
    {
        return promotionalRate;
    }
    public int getItemId()
    {
        return itemId;
    }
    public long getStockAmount(int index)
    {
        return itemStock[index];
    }
    /*public double getFreqLevel(int index)
    {
        return itemFreq[index];
    }
    */
}
