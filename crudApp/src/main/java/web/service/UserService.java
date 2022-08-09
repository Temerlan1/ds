package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void removeUserById(int id);

    List<User> findAll();

    User findById(int id);

    void cleanUsersTable();

    void update(User user, int id);
}
