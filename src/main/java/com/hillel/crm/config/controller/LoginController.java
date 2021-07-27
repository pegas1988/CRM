package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.Button;
import com.hillel.crm.config.entity.User;
import com.hillel.crm.config.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("      /loginMain")
public class LoginController{

    private UserService userService = new UserService();

    private String createButton(Button button, String buttonName) {
        button.setButtonForNavbar(buttonName);
        return button.getButtonForNavbar();
    }

    @GetMapping(value = "/login")
    public String getSomeString2() {
        return "login.jsp";
    }

    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
//        Button button = new Button();
//        String userName = req.getParameter("firstName");
//        String userLastName = req.getParameter("lastName");
//        String password = req.getParameter("psw");
//        User userFind = User.builder()
//                .firstName(userName)
//                .lastName(userLastName)
//                .build();
////        User user = userService.findByFirstAndLastName(userFind);
////        if (user.getPassword().equals(password)) {
////            //req.setAttribute("button", button);
////            req.setAttribute("user", user);
////
////            switch (user.getUserRole()) {
////                case DESIGNER:
////                    req.getSession().setAttribute("UserId", user.getUserID());
////                    return new ControllerResultDto("designer");
////                case DOCTOR:
////                    req.getSession().setAttribute("UserId", user.getUserID());
////                    return new ControllerResultDto("doctor");
////                case ADMIN: {
////                    req.getSession().setAttribute("UserId", user.getUserID());
////                    req.getSession().setAttribute("button", createButton(button, "admin"));
////                    return new ControllerResultDto("admin");
////                }
////                case ADMINISTRATOR: {
////                    req.getSession().setAttribute("UserId", user.getUserID());
////                    req.getSession().setAttribute("button", createButton(button, "administrator"));
////                    return new ControllerResultDto("administrator");
////                }
////                default:
////                    return new ControllerResultDto("error-403");
////            }
////        } else
        return new ControllerResultDto("error-403");
         }
}