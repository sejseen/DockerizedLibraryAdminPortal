package pwr.ktyma.libraryadminportal.adminservice.repo;


import org.springframework.data.repository.CrudRepository;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}