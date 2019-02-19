package com.company.hrm.service.impl;

import com.company.hrm.common.SpringIOC;
import com.company.hrm.dao.pojo.Emp;
import com.company.hrm.service.iService.IEmpService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmpServiceImplTest {
    IEmpService empService = (IEmpService) SpringIOC.getCtx().getBean("empService");
    @Test
    public void getEmpDao() {
    }

    @Test
    public void setEmpDao() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
        List<Emp> emps = empService.findAll();
        System.out.println(emps);
    }

    @Test
    public void findByPage() {
    }

    @Test
    public void findByName() {
    }
}