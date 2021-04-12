package com.victor.sneakpeek2;

import java.io.Serializable;

/**
 * The type Model.
 */
public class Model implements Serializable {

    private int image;
    private String title;
    private String desc;
    private String retail;
    private String date;

    /**
     * Instantiates a new Model.
     *
     * @param image  the image
     * @param title  the title
     * @param desc   the desc
     * @param retail the retail
     * @param date   the date
     */
    public Model(int image, String title, String desc, String retail, String date) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.retail = retail;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public int getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets retail.
     *
     * @return the retail
     */
    public String getRetail() {
        return retail;
    }

    /**
     * Sets retail.
     *
     * @param retail the retail
     */
    public void setRetail(String retail) {
        this.retail = retail;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }
}
