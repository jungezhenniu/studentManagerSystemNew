package com.biz.std.service.impl;

import com.biz.std.model.ClassNos;
import com.biz.std.repository.ClassNosRepository;
import com.biz.std.service.ClassNosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ClassNosServiceImpl implements ClassNosService{

    @Autowired
    private ClassNosRepository classNosRepository;

    public void addClassNos(ClassNos classNos) {
        classNosRepository.save(classNos);
    }

    public void deleteClassNos(ClassNos classNos) {
        classNosRepository.delete(classNos);
    }

    public ClassNos queryClassNosById(Integer id) {
            return classNosRepository.findOne(id);

        }

    public List<ClassNos> findAll() {
        return  classNosRepository.findAll();
    }
}
