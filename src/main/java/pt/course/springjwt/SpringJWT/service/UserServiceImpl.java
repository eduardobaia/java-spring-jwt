package pt.course.springjwt.SpringJWT.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.course.springjwt.SpringJWT.domain.Role;
import pt.course.springjwt.SpringJWT.domain.User;
import pt.course.springjwt.SpringJWT.repository.RoleRepository;
import pt.course.springjwt.SpringJWT.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRespository;

    @Override
    public User saveUser(User user) {
        log.info("Saving user");
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} ", role.getName());
        return roleRespository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        User user = userRepository.findByUsername(username);
        Role role = roleRespository.findByName(roleName);
        log.info("Assing  new role {} ", role.getName());
        // I can do it cause i'm using @transactional for all methods.
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {} ", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User not found!");
            throw new UsernameNotFoundException("User not found in database!");
        }else{
            log.info("User foind in database: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security
                .core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
    }
}
