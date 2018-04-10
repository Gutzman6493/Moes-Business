/*
    Project: Moes Business / Project FUN
    Last Edited by: Gutzman
    File Purpose: Item class. Holds all info for each
        individual item.
*/
package com.cis375.gutzman.moesbusiness;

public class Item
{
    // Variables for each Item
    private int itemId;
    private String itemName;
    private String itemDesc;
    private double itemCost;
    private double originalItemCost;
    private long[] itemStock; // index: 0 = Global 1-8 = Warehouse# Stock
    private int itemReorderValue;
    private double promotionalRate; // EXTRA
    private int minOpAmount;
    //private Vendor itemSeller;
    private String vendorName;
    private String category;
    private boolean backOrderFlag = false;

    // Constructor - Must have necessary info before constructing
    Item(String itemName, String category, int itemId, double itemCost, int itemReorderValue, int minOpAmount,
        String vendorName, long globalInv, long wh1Inv, long wh2Inv, long wh3Inv, long wh4Inv, long wh5Inv,
         long wh6Inv, long wh7Inv, long wh8Inv, String itemDesc)
    //FIXME ADD VENDOR INFO WHEN VENDOR CLASS IS MADE
    {
        this.itemName = itemName;
        this.category = category;
        this.itemDesc = itemDesc;
        this.itemId = itemId;
        this.promotionalRate = 0.0;
        this.itemCost = itemCost;
        originalItemCost = itemCost;
        this.itemReorderValue = itemReorderValue;
        this.minOpAmount = minOpAmount;
        itemStock = new long[9];
        itemStock[0] = globalInv;
        itemStock[1] = wh1Inv;
        itemStock[2] = wh2Inv;
        itemStock[3] = wh3Inv;
        itemStock[4] = wh4Inv;
        itemStock[5] = wh5Inv;
        itemStock[6] = wh6Inv;
        itemStock[7] = wh7Inv;
        itemStock[8] = wh8Inv;
        this.vendorName = vendorName;
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
    public String getVendorName()
    {
        return vendorName;
    }
    public String getCategory()
    {
        return category;
    }
    public boolean getBackOrderFlag()
    {
        return backOrderFlag;
    }
    public void setPromotionalRate(double rate)
    {
        promotionalRate = rate;
        itemCost = originalItemCost - (originalItemCost * rate);
    }
}
