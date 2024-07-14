package com.matthewblit.car_show.service;

import com.matthewblit.car_show.entity.Owner;

import java.util.List;

public interface OwnerService {
    Owner saveOwner(Owner owner);
    Owner getOwner(String id);
    List<Owner> getAllOwners();
}
