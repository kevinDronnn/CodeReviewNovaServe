package com.example.codereviewnovaserve.controller;

import com.example.codereviewnovaserve.dto.CarDto;
import com.example.codereviewnovaserve.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class CarControllerTest {

    final private int id = 1;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldSaveCar() throws Exception {
        CarDto carDto = new CarDto
                ("Mercedes","W223",2065,1.954 ,5.179, "black",3);
        doNothing().when(service).createCar(carDto);

        mockMvc.perform(post("/api/saveCar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carDto)))
                .andExpect(status().isCreated());

        verify(service, times(1)).createCar(any(CarDto.class));
    }

    @Test
    public void shouldGetCarById() throws Exception {
        when(service.getById(id)).thenReturn(new CarDto());


        mockMvc.perform(get("/api/getCarById/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(service, times(1)).getById(id);
    }

    @Test
    public void shouldDeleteCarById() throws Exception {
        doNothing().when(service).delete(id);

        mockMvc.perform(delete("/api/deleteCar/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(service, times(1)).delete(id);
    }

    @Test
    public void shouldUpdateCarById() throws Exception {
        CarDto carDto = new CarDto
                ("Mercedes","C",2065,1.954 ,5.179, "black",3);
        doNothing().when(service).update(id,carDto);

        mockMvc.perform(post("/api/updateCarById/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carDto)))
                .andExpect(status().isOk());

        verify(service, times(1)).update(eq(id),any(CarDto.class));
    }

    @Test
    public void shouldGetCarsByFilter() throws Exception{
        when(service.getEntitiesListByFilter("Mercedes")).thenReturn(List.of(new CarDto()));

        mockMvc.perform(get("/api/getCarsByFilter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("brand","Mercedes"))
                .andExpect(status().isOk());

        verify(service, times(1)).getEntitiesListByFilter("Mercedes");

    }
}