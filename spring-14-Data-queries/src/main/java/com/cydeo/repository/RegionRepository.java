package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {

    // Display all regions in Canada
    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country);

    // Display all region with country name includes 'United'
    List<Region> findByCountryContaining(String country);
    List<Region> getByCountryContains(String country);
}
