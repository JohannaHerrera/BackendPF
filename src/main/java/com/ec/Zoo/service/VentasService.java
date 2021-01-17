package com.ec.Zoo.service;

import com.ec.Zoo.entity.Ventas;
import com.ec.Zoo.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VentasService {
    @Autowired
    VentasRepository ventasRepository;

    public List<Ventas> list(){
        return ventasRepository.findAll();
    }

    public Optional<Ventas> getOne(int id){
        return ventasRepository.findById(id);
    }

    public void  save(Ventas ventas){
        ventasRepository.save(ventas);
    }

    public void delete(int id){
        ventasRepository.deleteById(id);
    }
}
