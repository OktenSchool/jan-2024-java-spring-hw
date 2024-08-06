package org.example.jan2024springhw.services;

import lombok.RequiredArgsConstructor;
import org.example.jan2024springhw.dto.CarDTO;
import org.example.jan2024springhw.dto.CarUpdateDTO;
import org.example.jan2024springhw.entities.Car;
import org.example.jan2024springhw.mapper.CarMapper;
import org.example.jan2024springhw.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream().map(carMapper::mapToDTO)
                .toList();
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car save = carRepository.save(carMapper.mapToCar(carDTO));
        return carMapper.mapToDTO(save);
    }

    public CarDTO getCarById(int id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("car with this id isn't present"));
        return carMapper.mapToDTO(car);
    }

    public CarDTO updateCar(int id, CarUpdateDTO carUpdateDTO) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("car with this id isn't present"));
        car.setBrand(carUpdateDTO.getBrand());
        car.setPrice(carUpdateDTO.getPrice());
        car.setYear(carUpdateDTO.getYear());
        Car savedCar = carRepository.save(car);
        return carMapper.mapToDTO(savedCar);

    }

    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }

}
