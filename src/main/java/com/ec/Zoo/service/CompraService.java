package com.ec.Zoo.service;

import com.ec.Zoo.entity.Compra;
import com.ec.Zoo.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompraService {
    @Autowired
    CompraRepository compraRepository;

    public List<Compra> list(){
        return compraRepository.findAll();
    }

    public Optional<Compra> getOne(int id){
        return compraRepository.findById(id);
    }

    public void  save(Compra compra){
        compraRepository.save(compra);
    }

    public void delete(int id){
        compraRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return compraRepository.existsById(id);
    }
}
