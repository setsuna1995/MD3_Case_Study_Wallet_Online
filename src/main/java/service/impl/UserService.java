package service.impl;

import dao.UserDAO;
import model.User;
import service.IUserService;

public class UserService implements IUserService {

    private final UserDAO userDAO = new UserDAO();


    @Override
    public void save(User user) {
        userDAO.insert(user);
    }

    @Override
    public boolean checkLogin(String userName, String password) throws Exception {
        return userDAO.checkLogin(userName, password);
    }
}
