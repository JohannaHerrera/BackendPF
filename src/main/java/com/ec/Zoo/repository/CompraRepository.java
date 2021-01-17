package com.ec.Zoo.repository;

import com.ec.Zoo.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{
    //Optional<Producto> findByNombre(String nombre);
    //boolean existsByNombre(String nombre);
}
