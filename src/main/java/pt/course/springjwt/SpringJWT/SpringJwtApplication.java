package pt.course.springjwt.SpringJWT;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pt.course.springjwt.SpringJWT.domain.Role;
import pt.course.springjwt.SpringJWT.domain.User;
import pt.course.springjwt.SpringJWT.service.UserService;

import java.beans.BeanProperty;
import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(
					new User(null, "Eduardo", "eduardobaia", "123456", new ArrayList<>()));
			userService.saveUser(
					new User(null, "joana", "joana", "123456", new ArrayList<>()));
			userService.saveUser(
					new User(null, "macabeia", "macabeia", "123456", new ArrayList<>()));
			userService.saveUser(
					new User(null, "goncalo", "goncalo", "123456", new ArrayList<>()));


			userService.addRoleToUser("eduardobaia", "ROLE_USER");
			userService.addRoleToUser("eduardobaia", "ROLE_ADMIN");
			userService.addRoleToUser("eduardobaia", "ROLE_SUPER_ADMIN");

			userService.addRoleToUser("joana", "ROLE_USER");
			userService.addRoleToUser("macabeia", "ROLE_USER");
			userService.addRoleToUser("goncalo", "ROLE_USER");





		};
	}

}
