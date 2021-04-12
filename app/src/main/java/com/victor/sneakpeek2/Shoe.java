package com.victor.sneakpeek2;

/**
 * The type Shoe.
 */
public class Shoe {

    private long ID;
    private String name;
    private String sku;

    /**
     * Instantiates a new Shoe.
     */
    public Shoe() {};

    /**
     * Instantiates a new Shoe.
     *
     * @param name the name
     * @param sku  the sku
     */
    public Shoe(String name, String sku) {
        this.name = name;
        this.sku = sku;
    }

    /**
     * Instantiates a new Shoe.
     *
     * @param ID   the id
     * @param name the name
     * @param sku  the sku
     */
    public Shoe(long ID, String name, String sku) {
        this.ID = ID;
        this.name = name;
        this.sku = sku;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getID() {
        return ID;
    }

    /**
     * Sets id.
     *
     * @param ID the id
     */
    public void setID(long ID) {
        this.ID = ID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets sku.
     *
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets sku.
     *
     * @param sku the sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }
}
