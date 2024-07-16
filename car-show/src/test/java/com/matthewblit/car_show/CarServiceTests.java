package com.matthewblit.car_show;

import com.matthewblit.car_show.entity.Car;
import com.matthewblit.car_show.repository.CarRepository;
import com.matthewblit.car_show.service.CarService;
import com.matthewblit.car_show.service.CarServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CarServiceTests {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void takeDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Update car when successful, Should return Car")
    public void updateCarShouldSucceedReturnCar() {
        Car car = Car.builder()
                .id(1l)
                .make("Ford")
                .model("F-150")
                .serial(UUID.randomUUID().toString())
                .year(2020)
                .color("Red")
                .price(45000.00)
                .build();
        Mockito.when(carRepository.findById(1l)).thenReturn(Optional.of(car));
        Mockito.when(carRepository.save(car)).thenReturn(car);

        Car car1 = carService.updateCar(car);

        assertThat(car1).isEqualTo(car);
    }

    @Test
    public void updateCarShouldFailThrowExceptionNoId() {
        Car car = Car.builder()
                .make("Ford")
                .model("F-150")
                .serial(UUID.randomUUID().toString())
                .year(2020)
                .color("Red")
                .price(45000.00)
                .build();

        Throwable throwable = assertThrows(Exception.class, () -> carService.updateCar(car));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable.getMessage()).isEqualTo("Id not found");
    }

    @Test
    public void updateCarShouldFailThrowExceptionInvalidId() {
        Car car = Car.builder()
                .id(-42l)
                .make("Ford")
                .model("F-150")
                .serial(UUID.randomUUID().toString())
                .year(2020)
                .color("Red")
                .price(45000.00)
                .build();

        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> carService.updateCar(car));

        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Car with id of -42 does not exist");
    }
}
