package com.matthewblit.car_show.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserCredentialService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
