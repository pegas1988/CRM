package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserController implements Controller {
    UserService userService = new UserService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
       // userService.deleteFromUser(user);
        return new ControllerResultDto("userdelete", true);
    }
}
