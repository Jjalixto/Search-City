package com.joel.pruebasunitarias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joel.pruebasunitarias.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long>{
    Country findCountryByIsoCode(String isoCode);
}
