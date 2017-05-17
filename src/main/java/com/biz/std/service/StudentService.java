package com.biz.std.service;

import com.biz.std.model.ClassNos;
import com.biz.std.model.Student;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by wangxianjun on 2017/5/4.
 */

public interface StudentService {
    @Transactional
    void addStudent(Student student);
    @Transactional
    void deleteStudent(Student student);
    Student queryStudentById(Integer id);
}
