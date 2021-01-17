package com.ec.Zoo.service;

import com.ec.Zoo.entity.Tarifa;
import com.ec.Zoo.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TarifaService {
    @Autowired
    TarifaRepository tarifaRepository;

    public List<Tarifa> list(){
        return tarifaRepository.findAll();
    }

    public Optional<Tarifa> getOne(int id){
        return tarifaRepository.findById(id);
    }

    public Optional<Tarifa> getByNombre(String nombre){
        return tarifaRepository.findByNombre(nombre);
    }

    public void  save(Tarifa tarifa){
        tarifaRepository.save(tarifa);
    }

    public void delete(int id){
        tarifaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return tarifaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return tarifaRepository.existsByNombre(nombre);
    }
}
