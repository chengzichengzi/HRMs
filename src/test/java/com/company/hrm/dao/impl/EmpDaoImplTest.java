package com.company.hrm.dao.impl;

import com.company.hrm.common.SpringIOC;
import com.company.hrm.dao.idao.IEmpDao;
import com.company.hrm.dao.pojo.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmpDaoImplTest {
    IEmpDao empDao;
    @Before
    public void setUp() throws Exception {
        empDao = (IEmpDao) SpringIOC.getCtx().getBean("empDao");
    }

    @After
    public void tearDown() throws Exception {
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
    public void findAll() throws Exception {
        List<Emp> emps = empDao.findAll();
        System.out.println(emps);
    }

    @Test
    public void findByPage() {
    }

    @Test
    public void findByName() {
    }
}