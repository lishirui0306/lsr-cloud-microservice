package cn.lsr.cloud.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @Description: 分页参数
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class PageParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageNumber;
    private int pageSize;
    private long total;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sortName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sortOrder;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
