package com.victor.sneakpeek2;

public class Shoe {

    private long ID;
    private String name;
    private String sku;

    public Shoe() {};

    public Shoe(String name, String sku) {
        this.name = name;
        this.sku = sku;
    }

    public Shoe(long ID, String name, String sku) {
        this.ID = ID;
        this.name = name;
        this.sku = sku;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
