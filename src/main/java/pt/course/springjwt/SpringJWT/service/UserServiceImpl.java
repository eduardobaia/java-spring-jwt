package pt.course.springjwt.SpringJWT.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.course.springjwt.SpringJWT.domain.Role;
import pt.course.springjwt.SpringJWT.domain.User;
import pt.course.springjwt.SpringJWT.repository.RoleRespository;
import pt.course.springjwt.SpringJWT.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRespository roleRespository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRespository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRespository.findByRoleName(roleName);
        // I can do it cause i'm using @transactional for all methods.
        user.getRoles().add(role);



    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
