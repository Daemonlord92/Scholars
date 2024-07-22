package com.matthewblit.car_show.controller;

import com.matthewblit.car_show.entity.UserCredential;
import com.matthewblit.car_show.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserCredentialService userCredentialService;

    @PostMapping("/login")
    public ResponseEntity<String> postLogin(@RequestBody UserCredential userCredential) {
        return ResponseEntity.ok(userCredentialService.login(userCredential));
    }

    @PostMapping("/")
    public ResponseEntity<?> postCreateUser(@RequestBody UserCredential userCredential) {
        userCredentialService.createUser(userCredential);
        return ResponseEntity.ok().build();
    }
}
