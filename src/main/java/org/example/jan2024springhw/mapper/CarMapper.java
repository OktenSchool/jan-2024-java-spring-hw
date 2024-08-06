package org.example.jan2024springhw.mapper;

import org.example.jan2024springhw.dto.CarDTO;
import org.example.jan2024springhw.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDTO mapToDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .price(car.getPrice())
                .year(car.getYear())
                .build();
    }

    public Car mapToCar(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
        return car;
    }
}
