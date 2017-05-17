package com.biz.std.vo;

/**
 * Created by wangxianjun on 2017/5/5.
 */

/**
 * 该vo适用于班级信息表单提交
 */
public class ClassNosAddVo {

    private String id;
    private String name;
    private int PageNos;
    private String classNosId;

    public int getPageNos() {
        return PageNos;
    }

    public void setPageNos(int pageNos) {
        PageNos = pageNos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassNosId() {
        return classNosId;
    }

    public void setClassNosId(String classNosId) {
        this.classNosId = classNosId;
    }
}
