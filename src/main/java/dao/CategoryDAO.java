package dao;

import model.Category;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends ConnectionUtil {
    public void insert(Category category) {
        String sql = "INSERT INTO category (`name`) VALUES (?)";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mPreparedStatement.setString(1, category.getName());
            mPreparedStatement.executeUpdate();
            mResultSet = mPreparedStatement.getGeneratedKeys();
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            open();
            String sql = "Select * from category";
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                int id = mResultSet.getInt("id");
                String name = mResultSet.getString("name");
                categoryList.add(new Category(id, name));
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }
}
