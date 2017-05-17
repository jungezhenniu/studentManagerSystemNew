package com.biz.std.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ClassNos {

    /**
     * 班级id
     */
    private Integer classNosId;
    /**
     * 班级名称
     */
    private String name;
    /**
     * 班级所对应学科集合
     */
    private Set<Subject> subjectSet;
    /**
     * 班级平均分
     */
    private Double avgScore;

    /**
     * 班级所对学生集合
     */
    private Set<Student> studentSet;

    @Id
    @GeneratedValue
    @Column(length = 4)
    public Integer getClassNosId() {
        return classNosId;
    }

    public void setClassNosId(Integer classNosId) {
        this.classNosId = classNosId;
    }

    @Column(length = 12)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    @Column(length = 6)
    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REMOVE},mappedBy = "classNos")
    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
