package io.games.simple.webapp.service;

import io.games.simple.webapp.entity.UserEntity;
import io.games.simple.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, CommonService<UserEntity, Long> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public CrudRepository<UserEntity, Long> getRepository() {
        return userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login).orElseThrow(
                ()->new UsernameNotFoundException("User of " + login + "doesn't exist")
        );
    }

}
