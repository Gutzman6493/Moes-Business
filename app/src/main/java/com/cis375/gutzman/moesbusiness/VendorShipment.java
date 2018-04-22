package com.cis375.gutzman.moesbusiness;

public class VendorShipment
{
    private String vendorId;
    private String vendorName;
    private String itemName;
    private String itemAmt;

    VendorShipment(){}

    VendorShipment(String vendorId, String vendorName, String itemName, String itemAmt)
    {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.itemName = itemName;
        this.itemAmt = itemAmt;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemAmt() {
        return itemAmt;
    }

    public void setItemAmt(String itemAmt) {
        this.itemAmt = itemAmt;
    }
}
