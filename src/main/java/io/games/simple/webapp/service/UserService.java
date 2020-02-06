package io.games.simple.webapp.service;

import io.games.simple.webapp.entity.UserEntity;
import io.games.simple.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                ()->new UsernameNotFoundException("User of " + email + "doesn't exist")
        );
    }

    public void save(UserEntity user) { userRepository.save(user); }

    public Long count(){ return userRepository.count(); }

}
