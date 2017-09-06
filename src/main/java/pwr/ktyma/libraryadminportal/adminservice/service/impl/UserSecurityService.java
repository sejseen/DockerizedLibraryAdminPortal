package pwr.ktyma.libraryadminportal.adminservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;
import pwr.ktyma.libraryadminportal.adminservice.repo.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("Username not found");

        return user;

    }
}
