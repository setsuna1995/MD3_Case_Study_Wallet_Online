package service.impl;

import dao.CategoryDAO;
import model.Category;
import service.ICategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    public void add(Category category) throws SQLException {

    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }
}
