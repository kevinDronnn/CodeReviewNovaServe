package com.example.codereviewnovaserve.controller;

import com.example.codereviewnovaserve.dto.CarDto;
import com.example.codereviewnovaserve.entity.CarEntity;
import com.example.codereviewnovaserve.mapper.CarMapper;
import com.example.codereviewnovaserve.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService service;

    @PostMapping("/saveCar")
    public ResponseEntity<String> saveCar(@RequestBody CarDto carDto){
        try{
            service.createCar(carDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("car was added");
        }catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("some fields are empty");
        }
    }
    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id){
        try{
            service.delete(id);
            return ResponseEntity.ok("car was deleted");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getCarById/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable int id){
        try{
            return ResponseEntity.ok(service.getById(id));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CarDto());
        }
    }

    @PostMapping("/updateCarById/{id}")
    public ResponseEntity<String> updateCarById(@PathVariable int id , @RequestBody CarDto carDto){
        try{
            service.update(id,carDto);
            return ResponseEntity.ok("car was updated");
        }catch (EntityNotFoundException | NullPointerException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getCarsByFilter")
    public ResponseEntity<List<CarDto>> getCarsByFilter(@RequestParam String brand){
        try{
            return ResponseEntity.ok(service.getEntitiesListByFilter(brand));
        }catch (EntityNotFoundException | NullPointerException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(new CarDto()));
        }
    }

}
