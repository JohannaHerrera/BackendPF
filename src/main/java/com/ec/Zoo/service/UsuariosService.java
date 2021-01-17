package com.ec.Zoo.service;

import com.ec.Zoo.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import com.ec.Zoo.repository.UsuariosRepository;

@Service
@Transactional
public class UsuariosService {
    @Autowired
    UsuariosRepository usuairoRepository;

    public List<Usuario> list(){
        return usuairoRepository.findAll();
    }

    public Optional<Usuario> getOne(int id){
        return usuairoRepository.findById(id);
    }

    public void  save(Usuario tarifa){
        usuairoRepository.save(tarifa);
    }

    public void delete(int id){
        usuairoRepository.deleteById(id);
    }
}
