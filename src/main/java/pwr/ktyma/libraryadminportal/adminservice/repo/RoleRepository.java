package pwr.ktyma.libraryadminportal.adminservice.repo;


import org.springframework.data.repository.CrudRepository;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);

}