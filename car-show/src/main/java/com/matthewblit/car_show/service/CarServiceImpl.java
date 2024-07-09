package com.matthewblit.car_show.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.matthewblit.car_show.dto.CarDto;
import com.matthewblit.car_show.entity.Car;
import com.matthewblit.car_show.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

//    public CarServiceImpl(CarRepository carRepository) {
//        this.carRepository = carRepository;
//    }

    @Override
    public Car createCar(CarDto carDto) {
        Car car = Car.builder()
                .make(carDto.make())
                .model(carDto.model())
                .year(carDto.year())
                .serial(UUID.randomUUID().toString())
                .build();
        return carRepository.save(car);
    }
}
