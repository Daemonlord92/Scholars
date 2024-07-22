package com.matthewblit.car_show.service;

import com.matthewblit.car_show.entity.UserCredential;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserCredentialService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    void createUser(UserCredential userCredential);
    String login(UserCredential userCredential);
}
