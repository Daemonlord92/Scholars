package com.matthewblit.car_show;

import com.matthewblit.car_show.controller.CarController;
import com.matthewblit.car_show.entity.Car;
import com.matthewblit.car_show.repository.CarRepository;
import com.matthewblit.car_show.repository.OwnerRepository;
import com.matthewblit.car_show.service.CarService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTests {

    @LocalServerPort
    private int port;

    @MockBean
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) {
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void updateCarShouldReturnCar() {
        Car exisitingCar = Car.builder()
                .id(1L)
                .make("Ford")
                .model("Focus")
                .serial(UUID.randomUUID().toString())
                .year(2019)
                .color("Blue")
                .price(20000.00)
                .build();
        Car updatedCar = Car.builder()
                .id(1L)
                .make("Ford")
                .model("F-150")
                .serial(UUID.randomUUID().toString())
                .year(2020)
                .color("Red")
                .price(45000.00)
                .build();

        when(carService.updateCar(updatedCar)).thenReturn(updatedCar);

        given()
                .contentType(ContentType.JSON)
                .body(updatedCar)
                .put("/api/v1/car/")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("make", equalTo("Ford"))
                .body("model", equalTo("F-150"))
                .body("year", equalTo(2020))
                .body("color", equalTo("Red"))
                .body("price", equalTo(45000.00F));
    }
}
