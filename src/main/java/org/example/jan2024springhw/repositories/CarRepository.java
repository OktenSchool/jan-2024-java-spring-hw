package org.example.jan2024springhw.repositories;

import org.example.jan2024springhw.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
