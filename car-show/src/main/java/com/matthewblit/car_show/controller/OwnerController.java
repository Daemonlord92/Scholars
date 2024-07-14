package com.matthewblit.car_show.controller;

import com.matthewblit.car_show.entity.Owner;
import com.matthewblit.car_show.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @PostMapping("/")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.saveOwner(owner));
    }

    @GetMapping("/")
    public ResponseEntity<List<Owner>> getAllOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable String id) {
        return  ResponseEntity.ok(ownerService.getOwner(id));
    }
}
