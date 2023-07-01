package pt.course.springjwt.SpringJWT.service;

import pt.course.springjwt.SpringJWT.domain.Role;
import pt.course.springjwt.SpringJWT.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
