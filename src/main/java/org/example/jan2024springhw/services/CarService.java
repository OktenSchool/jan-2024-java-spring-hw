package org.example.jan2024springhw.services;

import lombok.RequiredArgsConstructor;
import org.example.jan2024springhw.entities.Car;
import org.example.jan2024springhw.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    public Optional<Car> updateCar(int id, Car car) {
        return carRepository.findById(id).map(existCar -> {
            existCar.setBrand(car.getBrand());
            existCar.setPrice(car.getPrice());
            existCar.setYear(car.getYear());
            return carRepository.save(existCar);
        });
    }

    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }

}
