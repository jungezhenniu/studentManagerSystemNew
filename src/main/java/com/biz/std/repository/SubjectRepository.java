package com.biz.std.repository;

import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * Created by wangxianjun on 2017/5/4.
 */
public interface SubjectRepository extends JpaRepository<Subject,Integer>{
    /**
     * 根据传进来的字符串数据来查到对应的的学科
     * @return
     */
    Subject findSubjectByName(String name);
}
