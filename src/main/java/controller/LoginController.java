package controller;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller{

    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String userLastName = req.getParameter("userLastName");
        String password = req.getParameter("password");
        User userforSearch = new User(userName, userLastName);
        User user = userService.findByFirstAndLastName(userforSearch);

        if(user.getPassword().equals(password)) {
            req.setAttribute("user", user);
            return new ControllerResultDto("profile");
        } else {
            return new ControllerResultDto("error-403");
        }
    }
}