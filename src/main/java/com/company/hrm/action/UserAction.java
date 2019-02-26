package com.company.hrm.action;

import com.company.hrm.common.ResResult;
import com.company.hrm.common.ServiceConst;
import com.company.hrm.dao.pojo.User;
import com.company.hrm.service.iService.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserAction {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "user_Exsit.do", method = RequestMethod.GET)
    public @ResponseBody
    ResResult isExsit(String username) throws JsonProcessingException {
        boolean flag = userService.isExist(username);
        ResResult result = flag ? ResResult.success() : ResResult.error(404, "no such user");
        return result;
    }

    @RequestMapping(value = "user_Login.do", method = RequestMethod.POST)
    public @ResponseBody
    ResResult login(HttpServletRequest request, HttpServletResponse response, String username, String userpassword) throws JsonProcessingException {
        User user = userService.login(username, userpassword);
        ResResult<User> result = null;
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            result = ResResult.success("login success", user);
        } else {
            result = ResResult.error(500, "password error");
        }
        return result;
    }

    @RequestMapping(value = "user_Regist.do", method = RequestMethod.POST)
    public @ResponseBody
    ResResult regist(String username, String userpassword1, String userpassword2) throws JsonProcessingException {
        ResResult result = null;
        if (userService.isExist(username)) {
            result = ResResult.error(500, "username already exsit");
        } else if (username.isEmpty()) {
            result = ResResult.error(500, "empty info");
        } else if (userpassword1.equals(userpassword2)) {
            User user = new User(username, userpassword1, ServiceConst.DEFAULT_PRIORITY);
            String msg = userService.regist(user);
            if (msg.indexOf(ServiceConst.SUCCESS) != -1) {
                result = ResResult.success("regist success");
            } else {
                result = ResResult.error(500, "regist error");
            }
        } else {
            result = ResResult.error(500, "regist error");
        }
        return result;
    }

}
