package com.matthewblit.car_show.service;

import com.matthewblit.car_show.dto.CarDto;
import com.matthewblit.car_show.entity.Car;

public interface CarService {
    Car createCar(CarDto carDto);
}
