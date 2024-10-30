package com.joel.pruebasunitarias.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;
    @Column(name = "iso_code")
    private String isoCode;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_capital")
    private String countryCapital;
    @Column(name = "country_independence_date")
    private String countryIdependenceDate;
}
