package org.example.jan2024springhw.controllers;

import lombok.RequiredArgsConstructor;
import org.example.jan2024springhw.entities.Car;
import org.example.jan2024springhw.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping()
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        return ResponseEntity.of(carService.getCarById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car car) {
        return ResponseEntity.of(carService.updateCar(id, car));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteCar(@PathVariable int id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
}
