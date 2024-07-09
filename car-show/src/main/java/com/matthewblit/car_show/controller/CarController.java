package com.matthewblit.car_show.controller;

import com.matthewblit.car_show.dto.CarDto;
import com.matthewblit.car_show.entity.Car;
import com.matthewblit.car_show.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/")
    public ResponseEntity<Car> postNewCar(@RequestBody CarDto carDto) {
        try{
            return ResponseEntity.ok(carService.createCar(carDto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
