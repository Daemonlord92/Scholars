package com.matthewblit.car_show;

import com.matthewblit.car_show.dto.CarDto;
import com.matthewblit.car_show.entity.Car;
import com.matthewblit.car_show.entity.Owner;
import com.matthewblit.car_show.repository.CarRepository;
import com.matthewblit.car_show.repository.OwnerRepository;
import com.matthewblit.car_show.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {
	private static Logger log = LoggerFactory.getLogger(CarShowApplication.class);

	@Autowired
	private CarService carService;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		log.info("MJM:l13:CarShowApplication: Before SpringApplication runs");
		SpringApplication.run(CarShowApplication.class, args);
		log.error("MJM:l15:CarShowApplication: After SpringApplication runs");
		log.warn("MJM:l16:CarShowApplication: Warning example");
		log.debug("MJM:l17:CarShowApplication: Debug example");
	}

	@Override
	public void run(String... args) throws Exception {
		CarDto carDto = new CarDto("600", "Lexus", 2024, "Black", 55000.00);
		Car car = carService.createCar(carDto);
		//log.info(car.toString());

		List<Car> cars = List.of(
				Car.builder()
						.make("Ford")
						.model("F150")
						.year(1992)
						.serial(UUID.randomUUID().toString())
						.color("Gold")
						.price(5000.00)
						.build(),
				Car.builder()
						.make("BMW")
						.model("x5")
						.year(2024)
						.serial(UUID.randomUUID().toString())
						.color("Blue")
						.price(35000.00)
						.build()
		);

		carRepository.saveAll(cars);

		//log.info(carRepository.findAll().toString());

		Owner owner = Owner.builder()
				.name("Jacob")
				.address("123 String St")
				.email("test@test.com")
				.phone("9072728359")
				.build();
		ownerRepository.save(owner);
		//Shuts down the app since no Car in database with Toyota Model
		//log.info(carService.getCarByModel("Toyota").toString());
	}
}
