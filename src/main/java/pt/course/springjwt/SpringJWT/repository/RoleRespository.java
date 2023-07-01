package pt.course.springjwt.SpringJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.course.springjwt.SpringJWT.domain.Role;

@Repository
public interface RoleRespository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);

}