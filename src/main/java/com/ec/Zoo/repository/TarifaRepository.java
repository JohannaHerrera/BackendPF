package com.ec.Zoo.repository;

import com.ec.Zoo.entity.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer>{
    Optional<Tarifa> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
