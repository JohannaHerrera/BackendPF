package com.ec.Zoo.repository;

import com.ec.Zoo.entity.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, Integer>{
    
}
