package com.ec.Zoo.controller;

import com.ec.Zoo.dto.Mensaje;
import com.ec.Zoo.dto.TarifaDto;
import com.ec.Zoo.entity.Tarifa;
import com.ec.Zoo.service.TarifaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifa")
@CrossOrigin(origins = "*")
public class TarifaController {
    @Autowired
    TarifaService tarifaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Tarifa>> list(){
        List<Tarifa> list = tarifaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Tarifa> getById(@PathVariable("id") int id){
        if(!tarifaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Tarifa tarifa = tarifaService.getOne(id).get();
        return new ResponseEntity(tarifa, HttpStatus.OK);
    }
    
    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Tarifa> getByNombre(@PathVariable("nombre") String nombre){
        if(!tarifaService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Tarifa tarifa = tarifaService.getByNombre(nombre).get();
        return new ResponseEntity(tarifa, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TarifaDto tarifaDto){
        if(StringUtils.isBlank(tarifaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tarifaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatorio"), HttpStatus.BAD_REQUEST);
        if(tarifaDto.getPrecio()==null || tarifaDto.getPrecio()<=0 )
            return new ResponseEntity(new Mensaje("El precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(tarifaService.existsByNombre(tarifaDto.getNombre()))
            return new ResponseEntity(new Mensaje("Ese nombre de tarifa ya existe"), HttpStatus.BAD_REQUEST);
        Tarifa tarifa = new Tarifa(tarifaDto.getNombre(), tarifaDto.getDescripcion(),tarifaDto.getPrecio());
        tarifaService.save(tarifa);
        return new ResponseEntity(new Mensaje("Tarifa creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody TarifaDto tarifaDto){
        if(!tarifaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(tarifaService.existsByNombre(tarifaDto.getNombre()) && tarifaService.getByNombre(tarifaDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese nombre de tarifa ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tarifaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tarifaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        if(tarifaDto.getPrecio()==null || tarifaDto.getPrecio()<=0 )
            return new ResponseEntity(new Mensaje("El precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Tarifa tarifa = tarifaService.getOne(id).get();
        tarifa.setNombre(tarifaDto.getNombre());
        tarifa.setDescripcion(tarifaDto.getDescripcion());
        tarifa.setPrecio(tarifaDto.getPrecio());
        tarifaService.save(tarifa);
        return new ResponseEntity(new Mensaje("Tarifa actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!tarifaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        tarifaService.delete(id);
        return new ResponseEntity(new Mensaje("Tarifa eliminada"), HttpStatus.OK);
    }
}
