package service;

import model.User;

public interface IUserService {
    void save(User user);

    boolean checkLogin(String userName, String password) throws Exception;
}
