package com.rentacar.repository;

import com.rentacar.CarRentingAppApplication;
import com.rentacar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
