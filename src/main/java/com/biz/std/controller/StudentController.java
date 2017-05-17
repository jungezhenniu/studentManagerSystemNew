package com.biz.std.controller;

import com.biz.std.model.ClassNos;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.ClassNosService;
import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.staticValue.ConstantList;
import com.biz.std.vo.ClassNosAddVo;
import com.biz.std.vo.StudentAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by wangxianjun on 2017/5/4.
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassNosService classNosService;


    Set<Student> studentSet = new HashSet<Student>();

    @Resource(name = "studentRepository")
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/toSave")
    public ModelAndView toSaveStudent() {
        ModelAndView modelAndView = new ModelAndView("studentAdd");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String saveStudent(StudentAddVo studentAddVo, @RequestParam(value = "file", required = false) MultipartFile file) {
        Student student = new Student();
        student.setName(studentAddVo.getName());
        student.setBirthday(studentAddVo.getBirthday());
        student.setGender(studentAddVo.getGender());
        student.setNumber(studentAddVo.getNumber());

        String path;
        if (!file.isEmpty()) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String contentType = file.getContentType();
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "/static/images/" + uuid + "." + imageName;
            String imageUrl = "D:/IdeaProjects/studentManagerSystem/studentManagerSystem/target/std" + path;
            student.setFile(imageUrl);
        }
        studentService.addStudent(student);
        return "redirect:/student/studentList";
    }

    @RequestMapping("/studentList")
    public ModelAndView findStudentList(StudentAddVo studentAddVo) {
        List<Subject> subjectList = subjectService.findAll();
        int pageNos;
        ModelAndView modelAndView = new ModelAndView();
        Pageable pageable = new PageRequest(studentAddVo.getPageNos(), ConstantList.getPageSize());
        Page page = studentRepository.findAll(pageable);
        modelAndView.addObject("myPage", page.getContent());
        modelAndView.addObject("countPage", page.getTotalPages());
        modelAndView.addObject("subjectList", subjectList);
        modelAndView.addObject("countSubject", studentAddVo.getCountSubject());
        modelAndView.setViewName("studentList");
        pageNos = studentAddVo.getPageNos();
        if (pageNos < 1) {
            pageNos = 0;
        }
        else pageNos = studentAddVo.getPageNos();
        modelAndView.addObject("pageNos", pageNos);
        return modelAndView;
    }

    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable String id) {
        Integer id02 = Integer.parseInt(id);
        Student student = studentService.queryStudentById(id02);
        studentService.deleteStudent(student);
        return "redirect:/student/studentList";

    }

    @RequestMapping("/toUpdateStudent/{id}")
    public ModelAndView toUpdateStudent(@PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        Student student = studentService.queryStudentById(idInt);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentUpdate");
        modelAndView.addObject("student", student);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping("/update")
    public String updateStudent(StudentAddVo studentAddVo, @RequestParam(value = "file", required = false) MultipartFile file
    ) {

        String id = studentAddVo.getId();
        Integer id02 = Integer.parseInt(id);
        Student student = studentService.queryStudentById(id02);
        student.setName(studentAddVo.getName());
        student.setNumber(studentAddVo.getNumber());
        student.setBirthday(studentAddVo.getBirthday());
        student.setGender(studentAddVo.getGender());

        String path;
        if (!file.isEmpty()) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String contentType = file.getContentType();
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "/static/images/" + uuid + "." + imageName;
            String imageUrl = "D:/IdeaProjects/studentManagerSystem/studentManagerSystem/target/std" + path;
            System.out.println("看看路径:" + imageUrl);
            student.setFile(imageUrl);
            studentRepository.save(student);
        }
        return "redirect:/student/studentList";
    }

    @RequestMapping("/toAddScore/{id}")
    public ModelAndView toAddScore( @PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        Student student = studentService.queryStudentById(idInt);
        Set<Subject> subjectSet = student.getSubjectSet();
        ModelAndView modelAndView = new ModelAndView("addScore");
        modelAndView.addObject("id", id);
        modelAndView.addObject("subjectSet", subjectSet);
        return modelAndView;
    }

    @RequestMapping("/addScore/{id}")
    public ModelAndView addScore(StudentAddVo studentAddVo, @PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        Student student = studentService.queryStudentById(idInt);
        //拿到了学生
        Set<Subject> subjectSet = student.getSubjectSet();
        //拿到了学生对应的学科
        List<Subject> subjectList = new ArrayList<Subject>();
        for (Subject subject : subjectSet) {
            subjectList.add(subject);
        }
        String[] score = studentAddVo.getScore();
        double scoreSum = 0;

        List<Score> scoreList = new ArrayList<Score>();
            for (int i = 0; i < score.length; i++) {
                Score scoreStudentSubject = new Score();
                scoreSum += Double.parseDouble(score[i]);
                scoreStudentSubject.setScoreValue(Double.parseDouble(score[i]));
                scoreStudentSubject.setStudent(student);
                scoreStudentSubject.setSubject(subjectList.get(i));
                scoreList.add(scoreStudentSubject);
                scoreService.saveScore(scoreStudentSubject);
            }
        double avgScore = scoreSum / score.length;
        student.setAvgScore(avgScore);
        studentService.addStudent(student);
        ModelAndView modelAndView = new ModelAndView("addScoreSuccess");
        modelAndView.addObject("student", student);
        modelAndView.addObject("subjectList", subjectList);
        modelAndView.addObject("scoreList", scoreList);
        return modelAndView;
    }

    @RequestMapping("/toAddClassNos/{id}")
    public ModelAndView toAddClassNos(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("addClassNos");
        List<ClassNos> classNosList = classNosService.findAll();
        modelAndView.addObject("classNosList", classNosList);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping("/addClassNos/{id}")
    public ModelAndView addClassNos(ClassNosAddVo classNosAddVo, @PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        Student student = studentService.queryStudentById(idInt);
       String classNosId = classNosAddVo.getClassNosId();
       Integer idIntTwo = Integer.parseInt(classNosId);
       ClassNos classNos = classNosService.queryClassNosById(idIntTwo);
        student.setClassNos(classNos);
        studentSet.add(student);
        classNos.setStudentSet(studentSet);
        classNosService.addClassNos(classNos);
        //把学生设置到班级中，然后进行保存
        studentService.addStudent(student);
        //把班级设置到学生中，然后再进行保存，
        ModelAndView modelAndView = new ModelAndView("addClassNosSuccess");
        modelAndView.addObject("student", student);
        modelAndView.addObject("classNos", classNos);
        return modelAndView;
    }
   
}



