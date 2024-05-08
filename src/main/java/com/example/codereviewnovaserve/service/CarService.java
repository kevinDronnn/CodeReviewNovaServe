package com.example.codereviewnovaserve.service;

import com.example.codereviewnovaserve.dto.CarDto;
import com.example.codereviewnovaserve.entity.CarEntity;
import com.example.codereviewnovaserve.mapper.CarMapper;
import com.example.codereviewnovaserve.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarService {
    private static Logger logger = LoggerFactory.getLogger(CarService.class);

    @Autowired
    CarRepository repository;

    @Transactional
    public void createCar(CarDto carDto){
        Optional<CarDto> carDtoOptional = Optional.ofNullable(carDto);
        if (carDtoOptional.isPresent()){
            repository.save(CarMapper.INSTANCE.carDtoToCarEntity(carDtoOptional.get()));
            logger.info("car was added");
        }else {
            throw new NullPointerException();
        }
    }

    public CarDto getById(int id){
        Optional<CarEntity> carEntity = repository.findById(id);
        if (carEntity.isPresent()){
            return CarMapper.INSTANCE.carEntityToCarDto(carEntity.get());
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public void update(int id, CarDto carDto){
        Optional<CarEntity> carEntity = repository.findById(id);
        Optional<CarDto> carDtoOptional = Optional.ofNullable(carDto);
        if (carEntity.isPresent()){
            if (carDtoOptional.isPresent()){
                carDtoOptional.get().setId(carEntity.get().getId());
                repository.save(CarMapper.INSTANCE.carDtoToCarEntity(carDtoOptional.get()));
                logger.info("car was updated");
            }else {
                throw new NullPointerException();
            }
        }else {
            throw new EntityNotFoundException();
        }
    }

    public List<CarDto> getEntitiesListByFilter(String brand){
        Optional<List<CarEntity>> carEntity = Optional.ofNullable(repository.getCarEntitiesByBrand(brand));
        if (carEntity.isPresent()){
            return CarMapper.INSTANCE.carEntityToCarDtoList(carEntity.get());
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public void delete(int id){
        Optional<CarEntity> carEntity = repository.findById(id);
        if (carEntity.isPresent()){
            repository.deleteById(id);
            logger.info("car was deleted");
        }else {
            throw new EntityNotFoundException();
        }
    }


}
