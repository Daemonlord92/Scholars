package com.matthewblit.car_show.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.matthewblit.car_show.annotation.LogExecutionTime;
import com.matthewblit.car_show.dto.CarDto;
import com.matthewblit.car_show.entity.Car;
import com.matthewblit.car_show.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    @LogExecutionTime
    public Car createCar(CarDto carDto) {
        Car car = Car.builder()
                .make(carDto.make())
                .model(carDto.model())
                .year(carDto.year())
                .serial(UUID.randomUUID().toString())
                .color(carDto.color())
                .price(carDto.price())
                .build();
        return carRepository.save(car);
    }

    @Override
    @LogExecutionTime
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    @LogExecutionTime
    public Car getCarByModel(String model) {

        return carRepository.findByModel(model)
                .orElseThrow(() -> new EntityNotFoundException("Car with the model name " + model + " not found"));
    }

    @Override
    public Car updateCar(Car car) {
        if(car.getId() == null){
            throw new IllegalArgumentException("Id not found");
        }
        Car oldData = carRepository.findById(car.getId())
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Car with id of " + car.getId() + " does not exist");
                });
        oldData = car;
        return carRepository.save(oldData);
    }
}
