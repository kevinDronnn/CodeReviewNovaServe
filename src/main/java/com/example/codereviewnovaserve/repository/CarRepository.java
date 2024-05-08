package com.example.codereviewnovaserve.repository;

import com.example.codereviewnovaserve.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    List<CarEntity> getCarEntitiesByBrand(String brand);
}
