package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {

    private final IUserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                loginUserForm(request,response);
                break;
            case "register":
                registerUserForm(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "login":
                try {
                    loginUser(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "register":
                registerUser(request, response);
                break;
            default:
                break;
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(this.userService.checkLogin(userName, password)){
            request.setAttribute("userName", userName);

//            Bổ sung Session để lưu thông tin userName
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/user-servlet?action=login");
        }
    }

    private void loginUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/loginForm.jsp");
        dispatcher.forward(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        User user = new User(name, userName, password,address);
        this.userService.save(user);

        //Bổ sung trang điều hướng
        request.setAttribute("message", "New customer was created");
    }

    private void registerUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/registerForm.jsp");
        dispatcher.forward(request, response);
    }
}