package com.biz.std.service;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangxianjun on 2017/5/12.
 */
public interface ScoreService {
    @Transactional
     void saveScore(Score score);
    List<Score> getSumScore(Subject subject);
     List<Score> getScoreByStudent(Student student);
}
