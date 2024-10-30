package com.joel.pruebasunitarias.util;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DiferenciaEntreFechasTest {
    
    @Autowired
    private DiferenciaEntreFechas diferenciaEntreFechas;

    @Test
    void testCalculateYearsOfIndependency() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        LocalDate today = LocalDate.now();
        String fechaIndependencia = "24/02/2023";

        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaIndependencia);

        Assertions.assertEquals(5, resultado.getDays());
        Assertions.assertEquals(8, resultado.getMonths());
        Assertions.assertEquals(1, resultado.getYears());
    }
}
