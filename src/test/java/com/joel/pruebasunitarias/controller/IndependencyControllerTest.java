package com.joel.pruebasunitarias.controller;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.joel.pruebasunitarias.models.Country;
import com.joel.pruebasunitarias.models.CountryResponse;
import com.joel.pruebasunitarias.repositories.CountryRepository;
import com.joel.pruebasunitarias.util.DiferenciaEntreFechas;

public class IndependencyControllerTest {
    @Autowired
    CountryResponse countryResponse;

    @Autowired
    Optional<Country> country;

    //Objeto falso de la clase CountryRepository
    CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();

    @Autowired
    IndependencyController independencyController = new IndependencyController(countryRepositoryMock, diferenciaEntreFechas);

    @BeforeEach
    void setUp() {
        Country mockCountry = new Country();
        mockCountry.setIsoCode("DO");
        mockCountry.setCountryIdependenceDate("27/02/1844");
        mockCountry.setCountryId((long)1);
        mockCountry.setCountryName("República Dominicana");    
        mockCountry.setCountryCapital("Santo Domingo");    

        Mockito.when(countryRepositoryMock.findCountryByIsoCode("DO")).thenReturn(mockCountry);
    }

    @Test
    void getCountryDetailsWithValidCountryCode() {
        ResponseEntity<CountryResponse> respuestaServicio;
        respuestaServicio = independencyController.getCountryDetails("DO");
        // System.out.println("go"+respuestaServicio.getBody().getIndependenceDate());
        Assertions.assertEquals("República Dominicana", respuestaServicio.getBody().getCountryName());
    }

    @Test
    void getCountryDetailsWithInvalidCountryCode() {
        ResponseEntity<CountryResponse> respuestaServicio;
        respuestaServicio = independencyController.getCountryDetails("IT");
        // System.out.println("go"+respuestaServicio.getBody().getIndependenceDate());
        Assertions.assertNull(null,respuestaServicio.getBody().getCountryName());
    }
}
