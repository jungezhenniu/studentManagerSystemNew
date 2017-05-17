package com.biz.std.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by wangxianjun on 2017/5/4.
 */
@Entity
public class Student{

    /**
     * 学生id
     */

    private Integer studentId;

    /**
     * 学生学号
     */
    private String number;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生照片存储位置
     */
    private String file;

    /**
     * 学生性别
     */
    private String gender;

    /**
     * 学生生日
     */
    private Date birthday;


    /**
     * 学生平均分
     */
    private double avgScore;

    /**
     * 学科集合
     */

    private Set<Subject> subjectSet;

    /**
     * 学生所在班级
     */
    private ClassNos classNos;


    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }
    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    @Id
    @GeneratedValue
    @Column(length = 4)
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Column(length = 6)
    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Column(length = 12)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 12)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Column(length = 10)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @ManyToOne(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    public ClassNos getClassNos() {
        return classNos;
    }

    public void setClassNos(ClassNos classNos) {
        this.classNos = classNos;
    }

    @Override
    public String toString() {
        return "name:" + name + "  "+"gender:" + gender + "  " +"number:" + number +"  "+ "birthday:" + birthday;
    }
}
