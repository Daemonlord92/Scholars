package com.matthewblit.car_show.service;

import com.matthewblit.car_show.dto.CarDto;
import com.matthewblit.car_show.entity.Car;

import java.util.List;

public interface CarService {
    Car createCar(CarDto carDto);
    List<Car> getAllCars();
    Car getCarByModel(String model);

    Car updateCar(Car car);
}
