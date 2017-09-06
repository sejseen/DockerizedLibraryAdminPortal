package pwr.ktyma.libraryadminportal.adminservice.service;

import pwr.ktyma.libraryadminportal.adminservice.domain.User;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.UserRole;

import java.util.Set;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}