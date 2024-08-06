package org.example.jan2024springhw.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jan2024springhw.dto.CarDTO;
import org.example.jan2024springhw.dto.CarUpdateDTO;
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
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping()
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarDTO car) {
        return ResponseEntity.ok(carService.createCar(car));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable int id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable int id, @RequestBody CarUpdateDTO car) {
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteCar(@PathVariable int id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
}
