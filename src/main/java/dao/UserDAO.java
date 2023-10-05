package dao;

import model.User;
import util.ConnectionUtil;

import java.sql.Statement;

public class UserDAO extends ConnectionUtil {
    public void insert(User user) {
        String sql = "INSERT INTO user (`name`, `userName`, `password`, `address`, `totalMoney`) VALUES (?, ?, ?, ?, 0)";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mPreparedStatement.setString(1, user.getName());
            mPreparedStatement.setString(2, user.getUserName());
            mPreparedStatement.setString(3, user.getPassword());
            mPreparedStatement.setString(4, user.getAddress());
            mPreparedStatement.executeUpdate();
            mResultSet = mPreparedStatement.getGeneratedKeys();
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkLogin(String username, String password) throws Exception{
        boolean blCheck = false;
        String sql = "select * from user where userName = ? and password = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, username);
            mPreparedStatement.setString(2, password);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                blCheck = true;
            }
        } finally {
            close();
        }
        return blCheck;
    }

}
