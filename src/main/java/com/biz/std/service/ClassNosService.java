package com.biz.std.service;

import com.biz.std.model.ClassNos;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClassNosService {
    @Transactional
     void addClassNos(ClassNos classNos);
    @Transactional
     void deleteClassNos(ClassNos classNos);
    @Transactional
     ClassNos queryClassNosById(Integer id);
     List<ClassNos> findAll();
}
