package com.biz.std.model;

import javax.persistence.*;

/**
 * Created by wangxianjun on 2017/5/12.
 */
@Entity
public class Score {
    /**
     * 分数表id
     */
    private Integer scoreId;
    /**
     * 分数
     */
    private double scoreValue;
    /**
     * 对应学科
     */
    private Subject subject;
    /**
     * 对应学生
     */
    private Student student;

    @Id
    @GeneratedValue
    @Column(length = 4)
    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    @Column(length = 6)
    public double getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(double scoreValue) {
        this.scoreValue = scoreValue;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name="subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name="student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "分数:" + this.scoreValue + " " + "对应学生:" + this.student + " " + "对应科目: " + this.subject;
    }
}
