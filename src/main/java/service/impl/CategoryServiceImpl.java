package service.impl;

import model.Category;
import model.User;
import service.CategoryService;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public void add(Category category) throws SQLException {

    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = new ConnectionUtil();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String address = rs.getString("address");
                float totalMoney = Float.parseFloat(rs.getString("totalMoney"));
                users.add(new User(id, name, userName, password, address, totalMoney));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
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
