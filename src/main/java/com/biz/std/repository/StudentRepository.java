package com.biz.std.repository;

import com.biz.std.model.ClassNos;
import com.biz.std.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wangxianjun on 2017/5/4.
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{
}
