package pwr.ktyma.libraryadminportal.adminservice.service.impl;

import groovy.util.logging.Log;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.UserRole;
import pwr.ktyma.libraryadminportal.adminservice.repo.RoleRepository;
import pwr.ktyma.libraryadminportal.adminservice.repo.UserRepository;
import pwr.ktyma.libraryadminportal.adminservice.service.UserService;

import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception{
        User localUser = userRepository.findByUsername(user.getUsername());


        for (UserRole role : userRoles) {
                roleRepository.save(role.getRole());
            }

        user.getUserRoles().addAll(userRoles);
        localUser = userRepository.save(user);

        return localUser;

    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}

