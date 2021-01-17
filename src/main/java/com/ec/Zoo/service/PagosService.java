package com.ec.Zoo.service;

import com.ec.Zoo.entity.Pagos;
import com.ec.Zoo.repository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PagosService {
    @Autowired
    PagosRepository pagosRepository;

    public List<Pagos> list(){
        return pagosRepository.findAll();
    }

    public Optional<Pagos> getOne(int id){
        return pagosRepository.findById(id);
    }

    public void  save(Pagos pagos){
        pagosRepository.save(pagos);
    }

    public void delete(int id){
        pagosRepository.deleteById(id);
    }
}
