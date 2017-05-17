package com.biz.std.repository;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sun.rmi.log.LogInputStream;

import java.util.List;

/**
 * Created by wangxianjun on 2017/5/12.
 */
public interface ScoreRepository extends JpaRepository<Score,Integer>{


     List<Score> findScoreBySubject(Subject subject);

     List<Score> findByStudent(Student student);
}
