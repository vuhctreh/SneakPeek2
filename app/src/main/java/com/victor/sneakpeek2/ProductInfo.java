package com.victor.sneakpeek2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Product info.
 */
public class ProductInfo {
    // for json parsing via Retrofit2. Generated via http://www.jsonschema2pojo.org/
    @SerializedName("ProductActivity")
    @Expose
    private List<ProductActivity> productActivity = null;
    @SerializedName("Pagination")
    @Expose
    private Pagination pagination;

    /**
     * Gets product activity.
     *
     * @return the product activity
     */
    public List<ProductActivity> getProductActivity() {
        return productActivity;
    }

    /**
     * Sets product activity.
     *
     * @param productActivity the product activity
     */
    public void setProductActivity(List<ProductActivity> productActivity) {
        this.productActivity = productActivity;
    }

    /**
     * Gets pagination.
     *
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * Sets pagination.
     *
     * @param pagination the pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
