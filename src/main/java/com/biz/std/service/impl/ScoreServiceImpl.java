package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangxianjun on 2017/5/12.
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scoreRepository;

    public void saveScore(Score score) {
        scoreRepository.save(score);
    }

    public List<Score> getSumScore(Subject subject) {
        return scoreRepository.findScoreBySubject(subject);
    }

    public List<Score> getScoreByStudent(Student student) {
        return scoreRepository.findByStudent(student);
    }
}
