package com.biz.std.controller;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;

import com.biz.std.repository.SubjectRepository;

import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;

import com.biz.std.staticValue.ConstantList;
import com.biz.std.vo.SubjectAddVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangxianjun on 2017/5/4.
 */
@Controller
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectRepository getSubjectRepository() {
        return subjectRepository;
    }


    @RequestMapping("/toSave")
    public ModelAndView toSaveSubject() {
        ModelAndView modelAndView = new ModelAndView("subjectAdd");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String saveSubject(SubjectAddVo subjectAddVo) {
        Subject subject = new Subject();
        subject.setName(subjectAddVo.getName());
        subjectService.addSubject(subject);
        return "redirect:/subject/subjectList";
    }

    @RequestMapping("/subjectList")
    public ModelAndView findSubjectList(SubjectAddVo subjectAddVo) {
        int pageNos;

        ModelAndView modelAndView = new ModelAndView();
        Pageable pageable = new PageRequest(subjectAddVo.getPageNos(), ConstantList.getPageSize());
        Page page = subjectRepository.findAll(pageable);
        modelAndView.addObject("myPage", page.getContent());
        modelAndView.addObject("countPage", page.getTotalPages());
        modelAndView.setViewName("subjectList");
        pageNos = subjectAddVo.getPageNos();
        if (pageNos < 1) {
            pageNos = 0;
        } else pageNos = subjectAddVo.getPageNos();
        modelAndView.addObject("pageNos", pageNos);
        return modelAndView;
    }

    @RequestMapping("/deleteSubject/{id}")
    public String deleteSubject(@PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        Subject subject = subjectService.querySubjectById(idInt);
        subjectService.deleteSubject(subject);
        return "redirect:/subject/subjectList";

    }

    @RequestMapping("/updateSubject/{id}")
    public ModelAndView toUpdateSubject(@PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        Subject subject = subjectService.querySubjectById(idInt);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("subjectUpdate");
        modelAndView.addObject("subject", subject);
        modelAndView.addObject("id", id);
        return modelAndView;

    }

    @RequestMapping("/update")
    public String updateSubject(SubjectAddVo subjectAddVo) {
        String id = subjectAddVo.getId();
        Integer idInt = Integer.parseInt(id);
        Subject subject = subjectService.querySubjectById(idInt);
        subject.setName(subjectAddVo.getName());
        subjectService.addSubject(subject);
        return "redirect:/subject/subjectList";
    }

    @RequestMapping("/toChooseSubject/{id}")
    public ModelAndView toChooseSubject(@PathVariable String id) {
        List<Subject> subjectList = subjectService.findAll();
        ModelAndView modelAndView = new ModelAndView("chooseSubject");
        modelAndView.addObject("subjectList",subjectList);
        modelAndView.addObject("id",id);
        return  modelAndView;
    }

    @RequestMapping("/chooseSubject")
    public ModelAndView chooseSubject(SubjectAddVo subjectAddVo) {
        int countSubject = 0;
       String[] subjectArray = subjectAddVo.getNameArray();
       String idInt = subjectAddVo.getId();
       Integer id = Integer.parseInt(idInt);
        Student student = studentService.queryStudentById(id);
        //拿出对应的学生，因为最后要把该学生保存进学科中，所以要先把这个学生转成set型
        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student);
        Set<Subject> subjectSet = new HashSet<Subject>();
        for(String idName:subjectArray) {
            int idQuery = Integer.parseInt(idName);
            Subject subject = subjectService.querySubjectById(idQuery);
            //通过提交过来的id，找到对应的学科
            //然后把选择这门课的学生设置进入subject
            subject.setStudentSet(studentSet);
            //保存这个学科
            subjectService.addSubject(subject);
            subjectSet.add(subject);
            countSubject ++;
        }
        student.setSubjectSet(subjectSet);
        studentService.addStudent(student);
        //把学科设置进入学生，然后保存学生
        ModelAndView modelAndView = new ModelAndView("chooseSubjectSuccess");
        modelAndView.addObject("countSubject",countSubject);
        modelAndView.addObject("student",student);
        modelAndView.addObject("subjectSet",subjectSet);

        return  modelAndView;
    }

    @RequestMapping("/getSubjectAvgScore/{subjectId}")
    public ModelAndView getSubjectAvgScore(@PathVariable String subjectId) {
        ModelAndView modelAndView = new ModelAndView("subjectAvgScore");
        Integer subjectIdInt = Integer.parseInt(subjectId);
        Subject subject = subjectService.querySubjectById(subjectIdInt);

        List<Score> scoreSum = scoreService.getSumScore(subject);

        double subjectScoreSum = 0;
        for (int i = 0; i < scoreSum.size(); i++) {
            subjectScoreSum += scoreSum.get(i).getScoreValue();
        }

        if (subject.getStudentSet().size() != 0) {
            double avgScore = subjectScoreSum / subject.getStudentSet().size();
            subject.setAvgScore(avgScore);
            subjectService.addSubject(subject);
            modelAndView.addObject("subject", subject);
        }
        return modelAndView;
    }
}



