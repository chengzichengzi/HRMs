package com.company.hrm.service.impl;

import com.company.hrm.common.SpringIOC;
import com.company.hrm.service.iService.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    IUserService userService;
    @Before
    public void setUp() throws Exception {
        userService = (IUserService) SpringIOC.getCtx().getBean("userService");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUserDao() {
    }

    @Test
    public void setUserDao() {
    }

    @Test
    public void regist() {
    }

    @Test
    public void login() {
    }

    @Test
    public void isExist() {
        boolean isExist = userService.isExist("root");
        System.out.println(isExist);
    }
}