package com.biz.std.controller;

import com.biz.std.model.Student;
import com.biz.std.model.ClassNos;
import com.biz.std.repository.ClassNosRepository;
import com.biz.std.service.ClassNosService;
import com.biz.std.service.StudentService;
import com.biz.std.staticValue.ConstantList;
import com.biz.std.vo.ClassNosAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Set;

/**
 * Created by wangxianjun on 2017/5/4.
 */
@Controller
@RequestMapping("classNos")
public class ClassNosController {

    @Autowired
    private ClassNosService classNosService;

    @Autowired
    private ClassNosRepository classNosRepository;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/toSave")
    public ModelAndView toSaveClassNos() {
        ModelAndView modelAndView = new ModelAndView("classNosAdd");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String saveClassNos(ClassNosAddVo classNosAddVo) {
        ClassNos classNos = new ClassNos();
        classNos.setName(classNosAddVo.getName());
        classNosService.addClassNos(classNos);
        return "redirect:/classNos/classNosList";
    }

    @RequestMapping("/classNosList")
    public ModelAndView findClassNosList(ClassNosAddVo classNosAddVo) {
        int pageNos;
        ModelAndView modelAndView = new ModelAndView();
        Pageable pageable = new PageRequest(classNosAddVo.getPageNos(), ConstantList.getPageSize());
        Page page = classNosRepository.findAll(pageable);

        modelAndView.addObject("myPage", page.getContent());
        modelAndView.addObject("countPage", page.getTotalPages());

        //这个放进去只是跟view一起放进对应的jsp中
        modelAndView.setViewName("classNosList");
        pageNos = classNosAddVo.getPageNos();
        if (pageNos < 1) {
            pageNos = 0;
        } else pageNos = classNosAddVo.getPageNos();
        modelAndView.addObject("pageNos", pageNos);
        return modelAndView;
    }

    @RequestMapping("/deleteClassNos/{id}")
    public String deleteClassNos(@PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        ClassNos ClassNos = classNosService.queryClassNosById(idInt);
        classNosService.deleteClassNos(ClassNos);
        return "redirect:/classNos/classNosList";

    }

    @RequestMapping("/updateClassNos/{id}")
    public ModelAndView toUpdateClassNos(@PathVariable String id) {
        Integer idInt = Integer.parseInt(id);
        ClassNos classNos = classNosService.queryClassNosById(idInt);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classNosUpdate");
        modelAndView.addObject("classNos", classNos);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping("/update")
    public String updateClassNos(ClassNosAddVo classNosAddVo) {
        String id = classNosAddVo.getId();
        Integer idInt = Integer.parseInt(id);
        ClassNos classNos = classNosService.queryClassNosById(idInt);

        classNos.setName(classNosAddVo.getName());
        classNosService.addClassNos(classNos);
        return "redirect:/classNos/classNosList";
    }

    @RequestMapping("/getClassNosAvgScore/{classNosId}")
    public ModelAndView getClassNosAvgScore(@PathVariable String classNosId) {

        ModelAndView modelAndView = new ModelAndView("classNosAvgScore");
        Integer classNosIdInt = Integer.parseInt(classNosId);
        ClassNos classNos = classNosService.queryClassNosById(classNosIdInt);
        Set<Student> studentSet = classNos.getStudentSet();
        double classNosScoreSum = 0.0;
        for (Student student : studentSet) {
            classNosScoreSum += student.getAvgScore();
        }
        if (studentSet.size()!=0) {
            double classNosAvgScore = classNosScoreSum / studentSet.size();
            classNos.setAvgScore(classNosAvgScore);
            modelAndView.addObject("classNos", classNos);
            classNosService.addClassNos(classNos);
        }
        return modelAndView;
    }


}



