package com.ec.Zoo.controller;

import com.ec.Zoo.dto.Mensaje;
import com.ec.Zoo.dto.CompraDto;
import com.ec.Zoo.entity.Compra;
import com.ec.Zoo.security.entity.Usuario;
import com.ec.Zoo.service.CompraService;
import com.ec.Zoo.service.UsuariosService;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins = "*")
public class CompraController {
    @Autowired
    CompraService compraService;
    
    @Autowired
    UsuariosService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Compra>> list(){
        List<Compra> list = compraService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/listaUser/{user}")
    public ResponseEntity<List<Compra>> listUser(@PathVariable("user") String user){       
        List<Compra> list = compraService.list();
        List<Compra> listUser = compraService.list();
        List<Usuario> usuarios = usuarioService.list();
        int idUser = 0;
        
        for(Usuario item: usuarios){
            if(item.getNombreUsuario().equals(user)){
                idUser = item.getId();
            }
        }
        listUser.clear();
        for(Compra comp: list){
            if(comp.getIdusuario() == idUser){
                listUser.add(comp);
            }
        }
        
        list = listUser;
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Compra> getById(@PathVariable("id") int id){
        if(!compraService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Compra compra = compraService.getOne(id).get();
        return new ResponseEntity(compra, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CompraDto compraDto){
        Date fechaActual =  new Date();
        /*if(compraDto.getFecha()==null)
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(compraDto.getFecha().compareTo(fechaActual)<0)
            return new ResponseEntity(new Mensaje("La fecha debe ser posterior a la actual"), HttpStatus.BAD_REQUEST);*/
        if(compraDto.getTotal()==null)
            return new ResponseEntity(new Mensaje("El total debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(compraDto.getObservacion()))
            return new ResponseEntity(new Mensaje("La observación es obligatorias"), HttpStatus.BAD_REQUEST);
        if(compraDto.getIdusuario()<=0)
            return new ResponseEntity(new Mensaje("Id de usuario no válido"), HttpStatus.BAD_REQUEST);
        Compra compra = new Compra(fechaActual, compraDto.getTotal(), compraDto.getObservacion(),
            compraDto.getIdusuario());
        compraService.save(compra);
        return new ResponseEntity(new Mensaje("Compra creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody CompraDto compraDto){
        Date fechaActual =  new Date();
        /*if(compraDto.getFecha()==null)
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(compraDto.getFecha().compareTo(fechaActual)<0)
            return new ResponseEntity(new Mensaje("La fecha debe ser posterior a la actual"), HttpStatus.BAD_REQUEST);*/
        if(compraDto.getTotal()==null)
            return new ResponseEntity(new Mensaje("El total debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(compraDto.getObservacion()))
            return new ResponseEntity(new Mensaje("La observación es obligatorias"), HttpStatus.BAD_REQUEST);
        if(compraDto.getIdusuario()<=0)
            return new ResponseEntity(new Mensaje("Id de usuario no válido"), HttpStatus.BAD_REQUEST);

        Compra compra = compraService.getOne(id).get();
        compra.setFecha(fechaActual);
        compra.setTotal(compraDto.getTotal());
        compra.setObservacion(compraDto.getObservacion());
        compra.setIdusuario(compraDto.getIdusuario());
        compraService.save(compra);
        return new ResponseEntity(new Mensaje("Compra actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!compraService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        compraService.delete(id);
        return new ResponseEntity(new Mensaje("Compra eliminada"), HttpStatus.OK);
    }
}
