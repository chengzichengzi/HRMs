package com.company.hrm.action;

import com.company.hrm.common.ResResult;
import com.company.hrm.common.ServiceConst;
import com.company.hrm.dao.pojo.Emp;
import com.company.hrm.service.iService.IEmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmpAction {
    @Autowired
    private IEmpService empService;
    @RequestMapping(value = "find_All_Emp.do",method = RequestMethod.GET)
    public @ResponseBody ResResult findAllEmp(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession();
        ResResult<List<Emp>> result = null;

        if(session.getAttribute("username") != null){
            List<Emp> empList = new ArrayList<Emp>();
            empList = empService.findAll();
            if (!empList.isEmpty() && empList.size() > 0) {
                result = ResResult.success("find all success", empList);
            }else {
                result = ResResult.error(404, "no data");
            }
        }else {
            result = ResResult.error(301, "have not login");
        }

        return result;
    }

    @RequestMapping(value = "delete_Emp.do" ,method = RequestMethod.GET)
    public @ResponseBody ResResult delete(Emp emp) throws JsonProcessingException {
        String msg = empService.delete(emp);
        ResResult result = null;
        if (msg.indexOf(ServiceConst.SUCCESS) != -1) {
            result = ResResult.success("delete success");
        }else {
            result = ResResult.error(500,"delete error");
        }

        return result;
    }

    @RequestMapping(value = "find_By_Id.do" ,method = RequestMethod.GET)
    public @ResponseBody ResResult findById(Integer empno) throws JsonProcessingException {
        ResResult<List<Emp>> result = null;
        Emp emp = null;
        if (empService.findById(empno) != null) {
            emp = empService.findById(empno);
            List<Emp> emps = Arrays.asList(emp);
            result = ResResult.success("find by id success", emps);
        }else {
            result = ResResult.error(404, "no such data");
        }
        return result;
    }

    @RequestMapping(value = "find_By_Name.do",method = RequestMethod.GET)
    public @ResponseBody ResResult findByName(String ename){
        List<Emp> empList = empService.findByName(ename);
        ResResult<List<Emp>> result = null;
        if (!empList.isEmpty() && empList.size()>0) {
            result = ResResult.success("find by name success", empList);
        }else {
            result = ResResult.error(404, "no data");
        }
        return result;
    }
    @RequestMapping(value = "save_Emp.do",method = RequestMethod.POST)
    public @ResponseBody ResResult saveEmp(@RequestBody Emp emp){

        String msg = empService.save(emp);
        ResResult result = null;
        if (msg.indexOf(ServiceConst.SUCCESS) != -1) {
            result = ResResult.success("save success");
        }else {
            result = ResResult.error(500, "save failed");
        }
        return result;
    }

    @RequestMapping(value = "update_emp.do",method = RequestMethod.POST)
    public @ResponseBody ResResult updateEmp(@RequestBody Emp emp){

        String msg = empService.update(emp);
        ResResult result = null;
        if (msg.indexOf(ServiceConst.SUCCESS) != -1) {
            result = ResResult.success("update success");
        }else {
            result = ResResult.error(500, "update failed");
        }
        return result;
    }


}
