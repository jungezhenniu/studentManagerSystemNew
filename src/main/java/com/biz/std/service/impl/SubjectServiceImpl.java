package com.biz.std.service.impl;

import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangxianjun on 2017/5/4.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectRepository getSubjectRepository() {
        return subjectRepository;
    }

    @Resource
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject);
    }

   /* public void updateStudent(String id, String name, String gender, String file, Date birthday, int number) {
            studentRepository.updateStudent(id,name,gender,file,birthday,number);

    }*/
    public Subject querySubjectById(Integer id) {

        return subjectRepository.findOne(id);

    }

    public List<Subject> findAll() {
        return  subjectRepository.findAll();
    }
    public Subject findByName(String name) {
        return subjectRepository.findSubjectByName(name);
    }
}
