package com.biz.std.service;
import com.biz.std.model.Subject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangxianjun on 2017/5/4.
 */

public interface SubjectService {
    @Transactional
    void addSubject(Subject subject);
    @Transactional
    void deleteSubject(Subject subject);
    Subject querySubjectById(Integer id);
    List<Subject> findAll();
}
