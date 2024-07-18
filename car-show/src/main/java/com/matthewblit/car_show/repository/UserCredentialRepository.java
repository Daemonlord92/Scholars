package com.matthewblit.car_show.repository;

import com.matthewblit.car_show.entity.UserCredential;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserCredentialRepository extends ListCrudRepository<UserCredential, String> {
    Optional<UserCredential> findByUsername(String username);
}
