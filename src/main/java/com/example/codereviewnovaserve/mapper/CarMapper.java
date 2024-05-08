package com.example.codereviewnovaserve.mapper;

import com.example.codereviewnovaserve.dto.CarDto;
import com.example.codereviewnovaserve.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "color", source = "color")
    @Mapping(target = "engineLiters", source = "engineLiters")
    CarEntity carDtoToCarEntity(CarDto carDto);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "color", source = "color")
    @Mapping(target = "engineLiters", source = "engineLiters")
    CarDto carEntityToCarDto(CarEntity carEntity);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "color", source = "color")
    @Mapping(target = "engineLiters", source = "engineLiters")
    List<CarDto> carEntityToCarDtoList(List<CarEntity> carEntityList);
}
