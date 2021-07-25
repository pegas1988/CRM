package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserController implements Controller {
    UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        User userFind = new User();
        userFind.builder().email(email);
        //User user = userService.findByEmail(userFind);
        //req.getSession().setAttribute("user", user);
        return new ControllerResultDto("updateProceed", true);
    }
}
