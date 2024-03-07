//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.finace.mybatis.helper;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageInfo<T> implements Serializable {
    public PageInfo() {
    }

    private static final long serialVersionUID = 4753989058279079506L;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 总记录条数
     */
    private Integer total;
    /**
     * 总页数
     */
    private Integer pages;
    private List<T> list;

    public PageInfo(int pageNum, int pageSize, int total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        if (total > 0) {
            this.total = total;
        }
        this.list = list;
        this.pages = (int) Math.ceil((double) total / (double) pageSize);
    }
}
