package controller;

import model.Category;
import service.ICategoryService;
import service.impl.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "CategoryServlet", urlPatterns = "/category-servlet")
public class CategoryServlet extends HttpServlet {
    private final ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                createCategoryForm(req,resp);
                break;
            case "edit":
//                editCategoryForm(req, resp);
                break;
            default:
                listCategory(req, resp);
                break;
        }
    }

    private void listCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/category/list.jsp");
        List<Category> categoryList = categoryService.findAll();
        req.setAttribute("categories", categoryList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
