package com.biz.std.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wangxianjun on 2017/5/5.
 */
@Entity
public class Subject {
    /**
     * 学科id
     */
    private Integer subjectId;
    /**
     * 学科名
     */
    private String name;
    /**
     * 学科平均分
     */
    private double avgScore;
    /**
     * 对应的学生集合
     */
    private Set<Student> studentSet;
    /**
     * 对应班级集合
     */
    private Set<ClassNos> classNosSet;
    @Id
    @GeneratedValue
    @Column(length = 4)
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Column(length = 12)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 6)
    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "课程名:" + this.name;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE,mappedBy = "subjectSet")
    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE,mappedBy = "subjectSet")
    public Set<ClassNos> getClassNosSet() {
        return classNosSet;
    }

    public void setClassNosSet(Set<ClassNos> classNosSet) {
        this.classNosSet = classNosSet;
    }
}

