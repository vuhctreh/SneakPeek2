package com.victor.sneakpeek2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Product activity.
 */
public class ProductActivity {
    // for ProductInfo json parsing. Generated via http://www.jsonschema2pojo.org/
    @SerializedName("chainId")
    @Expose
    private String chainId;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("shoeSize")
    @Expose
    private String shoeSize;
    @SerializedName("productId")
    @Expose
    private Object productId;
    @SerializedName("skuUuid")
    @Expose
    private String skuUuid;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("customerId")
    @Expose
    private Object customerId;
    @SerializedName("localAmount")
    @Expose
    private Integer localAmount;
    @SerializedName("localCurrency")
    @Expose
    private String localCurrency;

    /**
     * Gets chain id.
     *
     * @return the chain id
     */
    public String getChainId() {
        return chainId;
    }

    /**
     * Sets chain id.
     *
     * @param chainId the chain id
     */
    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets shoe size.
     *
     * @return the shoe size
     */
    public String getShoeSize() {
        return shoeSize;
    }

    /**
     * Sets shoe size.
     *
     * @param shoeSize the shoe size
     */
    public void setShoeSize(String shoeSize) {
        this.shoeSize = shoeSize;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public Object getProductId() {
        return productId;
    }

    /**
     * Sets product id.
     *
     * @param productId the product id
     */
    public void setProductId(Object productId) {
        this.productId = productId;
    }

    /**
     * Gets sku uuid.
     *
     * @return the sku uuid
     */
    public String getSkuUuid() {
        return skuUuid;
    }

    /**
     * Sets sku uuid.
     *
     * @param skuUuid the sku uuid
     */
    public void setSkuUuid(String skuUuid) {
        this.skuUuid = skuUuid;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public Object getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(Object customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets local amount.
     *
     * @return the local amount
     */
    public Integer getLocalAmount() {
        return localAmount;
    }

    /**
     * Sets local amount.
     *
     * @param localAmount the local amount
     */
    public void setLocalAmount(Integer localAmount) {
        this.localAmount = localAmount;
    }

    /**
     * Gets local currency.
     *
     * @return the local currency
     */
    public String getLocalCurrency() {
        return localCurrency;
    }

    /**
     * Sets local currency.
     *
     * @param localCurrency the local currency
     */
    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }
}