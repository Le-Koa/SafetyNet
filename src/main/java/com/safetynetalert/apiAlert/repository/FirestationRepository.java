package com.safetynetalert.apiAlert.repository;

import com.safetynetalert.apiAlert.Model.Firestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation,Long> {

    List<Firestation> findAll();

    Optional<Firestation> findByAddressAndStation(String address, String station);

    Optional<Firestation> findByAddress(String address);

    Optional<Firestation> findByStation(String station);

    void deleteByAddress(String address);

    void deleteByStation(String station);

    void deleteByStationAndAddress(String address,String station);

    List<Firestation> findDistinctByStation(String stationNumber);

    List<Firestation> findDistinctByAddress(String address);

    boolean existsByAddressAndStation (String address, String station);

    boolean existsByStation(String station);

}
