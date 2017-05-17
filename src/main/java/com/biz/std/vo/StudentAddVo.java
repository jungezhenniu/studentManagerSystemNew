package com.biz.std.vo;

import java.util.Date;

/**
 * Created by wangxianjun on 2017/5/5.
 */

/**
 * 该vo适用于学生信息表单提交
 */
public class StudentAddVo {
    private String id;
    private String name;
    private String gender;
    private String number;
    private Date birthday;
    private int PageNos;
    private String [] score;

    private int countSubject;

    public int getCountSubject() {
        return countSubject;
    }

    public void setCountSubject(int countSubject) {
        this.countSubject = countSubject;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String[] getScore() {
        return score;
    }

    public void setScore(String[] score) {
        this.score = score;
    }

}
