package com.matthewblit.car_show.service;

import com.matthewblit.car_show.entity.Owner;
import com.matthewblit.car_show.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwner(String id) {
        return ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
}
