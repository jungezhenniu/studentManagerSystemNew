package com.biz.std.service.impl;

import com.biz.std.model.ClassNos;
import com.biz.std.model.Student;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by wangxianjun on 2017/5/4.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public Student queryStudentById(Integer id) {

        return studentRepository.findOne(id);

    }
}
