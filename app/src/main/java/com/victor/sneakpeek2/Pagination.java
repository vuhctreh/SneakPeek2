package com.victor.sneakpeek2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Pagination.
 */
public class Pagination {
    // for ProductInfo json parsing. Generated via http://www.jsonschema2pojo.org/
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("sort")
    @Expose
    private List<String> sort = null;
    @SerializedName("order")
    @Expose
    private List<String> order = null;
    @SerializedName("lastPage")
    @Expose
    private String lastPage;
    @SerializedName("currentPage")
    @Expose
    private String currentPage;
    @SerializedName("nextPage")
    @Expose
    private String nextPage;
    @SerializedName("prevPage")
    @Expose
    private Object prevPage;

    /**
     * Gets limit.
     *
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets limit.
     *
     * @param limit the limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Gets sort.
     *
     * @return the sort
     */
    public List<String> getSort() {
        return sort;
    }

    /**
     * Sets sort.
     *
     * @param sort the sort
     */
    public void setSort(List<String> sort) {
        this.sort = sort;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public List<String> getOrder() {
        return order;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(List<String> order) {
        this.order = order;
    }

    /**
     * Gets last page.
     *
     * @return the last page
     */
    public String getLastPage() {
        return lastPage;
    }

    /**
     * Sets last page.
     *
     * @param lastPage the last page
     */
    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * Gets current page.
     *
     * @return the current page
     */
    public String getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets current page.
     *
     * @param currentPage the current page
     */
    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Gets next page.
     *
     * @return the next page
     */
    public String getNextPage() {
        return nextPage;
    }

    /**
     * Sets next page.
     *
     * @param nextPage the next page
     */
    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * Gets prev page.
     *
     * @return the prev page
     */
    public Object getPrevPage() {
        return prevPage;
    }

    /**
     * Sets prev page.
     *
     * @param prevPage the prev page
     */
    public void setPrevPage(Object prevPage) {
        this.prevPage = prevPage;
    }
}