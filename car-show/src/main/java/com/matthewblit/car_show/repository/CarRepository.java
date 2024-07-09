package com.matthewblit.car_show.repository;

import com.matthewblit.car_show.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

//PagingAndPaginationRepository
//JpaRepository
//ListCrudRepository
//ListPagingAndSortingRepository

public interface CarRepository extends ListCrudRepository<Car, Long> {
    List<Car> findByModelOrMake(String model, String make);
}
