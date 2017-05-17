package com.biz.std.vo;

import java.util.Date;

/**
 * Created by wangxianjun on 2017/5/5.
 */

/**
 * 该vo适用于学科信息表单提交
 */
public class SubjectAddVo {
    private String id;
    private String[] nameArray;
    private int PageNos;
    private String name;

    public int getPageNos() {
        return PageNos;
    }

    public void setPageNos(int pageNos) {
        PageNos = pageNos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getNameArray() {
        return nameArray;
    }

    public void setNameArray(String[] nameArray) {
        this.nameArray = nameArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
