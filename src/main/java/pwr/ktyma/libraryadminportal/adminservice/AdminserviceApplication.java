package pwr.ktyma.libraryadminportal.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.Role;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.UserRole;
import pwr.ktyma.libraryadminportal.adminservice.service.UserService;
import pwr.ktyma.libraryadminportal.adminservice.utility.SecurityUtility;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AdminserviceApplication implements CommandLineRunner{

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AdminserviceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		User admin = new User();
//		admin.setUsername("admin");
//		admin.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
//		admin.setEmail("admin@gmail.com");
//		Set<UserRole> adminRoles = new HashSet<>();
//		Role adm = new Role();
//		adm.setRoleId(0);
//		adm.setName("ROLE_ADMIN");
//		adminRoles.add(new UserRole(admin, adm));
//
//		userService.createUser(admin, adminRoles);
	}
}
