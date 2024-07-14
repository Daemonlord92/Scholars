package com.matthewblit.car_show.repository;

import com.matthewblit.car_show.entity.Owner;
import org.springframework.data.repository.ListCrudRepository;

public interface OwnerRepository extends ListCrudRepository<Owner, String> {
}
