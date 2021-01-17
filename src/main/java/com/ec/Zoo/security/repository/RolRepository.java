package com.ec.Zoo.security.repository;

import com.ec.Zoo.security.entity.Rol;
import com.ec.Zoo.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByRolNombre(RolNombre rolNombre);
}
