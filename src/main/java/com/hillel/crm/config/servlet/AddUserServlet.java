package com.hillel.crm.config.servlet;

import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.entity.roles;
import com.hillel.crm.config.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String userRole = req.getParameter("userRole");
        String password = req.getParameter("psw");

        User user = new User();
        user.builder()
                .email(email)
                .firstName(name)
                .lastName(lastName)
                .password(password)
                .userRole(roles.valueOf(userRole))
                .build();
        UserService us = new UserService();
      //  us.create(user);
        req.getRequestDispatcher("/WEB-INF/jsp/userWasCreated.jsp").forward(req, resp);
    }
}