package com.ec.Zoo.repository;

import com.ec.Zoo.entity.Tarifa;
import com.ec.Zoo.entity.Ventas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
    
}
