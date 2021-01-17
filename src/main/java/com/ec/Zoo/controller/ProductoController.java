package com.ec.Zoo.controller;

import com.ec.Zoo.dto.Mensaje;
import com.ec.Zoo.dto.ProductoDto;
import com.ec.Zoo.entity.Compra;
import com.ec.Zoo.entity.Producto;
import com.ec.Zoo.service.CompraService;
import com.ec.Zoo.service.ProductoService;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ec.Zoo.security.controller.AuthController;
import com.ec.Zoo.security.entity.Usuario;
import com.ec.Zoo.service.UsuariosService;

import java.util.List;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    ProductoService productoService;
    
    @Autowired
    CompraService compraService;
    
    @Autowired
    UsuariosService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list(){       
        List<Producto> list = productoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/listaUser/{user}")
    public ResponseEntity<List<Producto>> listUser(@PathVariable("user") String user){       
        List<Producto> list = productoService.list();
        List<Producto> listUser = productoService.list();
        Producto producto;
        List<Compra> compras = compraService.list();
        List<Usuario> usuarios = usuarioService.list();
        int idUser = 0;
        
        for(Usuario item: usuarios){
            if(item.getNombreUsuario().equals(user)){
                idUser = item.getId();
            }
        }
        listUser.clear();
        for(Compra comp: compras){
            if(comp.getIdusuario() == idUser){
                for(Producto item: list){
                    if(item.getIdcompra() == comp.getId()){
                        try{
                            producto = productoService.getOne(item.getId()).get();
                            listUser.add(producto);                           
                        }
                        catch(Exception e) {
                            System.out.println("Something went wrong.");
                        }
                    }
                }
            }
        }
        
        list = listUser;
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        Compra compra = null;
        Date fechaActual =  new Date();
        if(productoDto.getFecha()==null)
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(productoDto.getFecha().compareTo(fechaActual)<0)
            return new ResponseEntity(new Mensaje("La fecha debe ser posterior a la actual"), HttpStatus.BAD_REQUEST);
        if(productoDto.getIdtarifa()<=0 )
            return new ResponseEntity(new Mensaje("La tarifa es obligatoria"), HttpStatus.BAD_REQUEST);
        if(productoDto.getCantidad()<=0)
            return new ResponseEntity(new Mensaje("La cantidad debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(productoDto.getTotal()==null|| productoDto.getTotal()<=0)
            return new ResponseEntity(new Mensaje("El total debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        
        Producto producto = new Producto(productoDto.getFecha(), productoDto.getIdtarifa(), 
                productoDto.getCantidad(), productoDto.getTotal(), productoDto.getIdcompra());
        
        List<Compra> compras = compraService.list();
        
        for(Compra item: compras){
            if (item.getId() == productoDto.getIdcompra()){
                compra = compraService.getOne(item.getId()).get();
                compra.setTotal(compra.getTotal()+productoDto.getTotal());
            }
        }
        
        compraService.save(compra);
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Compra de boleto creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductoDto productoDto){
        Date fechaActual =  new Date();
        if(productoDto.getFecha()==null)
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(productoDto.getFecha().compareTo(fechaActual)<0)
            return new ResponseEntity(new Mensaje("La fecha debe ser posterior a la actual"), HttpStatus.BAD_REQUEST);
        if(productoDto.getIdtarifa()<=0 )
            return new ResponseEntity(new Mensaje("La tarifa es obligatoria"), HttpStatus.BAD_REQUEST);
        if(productoDto.getCantidad()<=0)
            return new ResponseEntity(new Mensaje("La cantidad debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(productoDto.getTotal()==null|| productoDto.getTotal()<=0)
            return new ResponseEntity(new Mensaje("El total debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        Producto producto = productoService.getOne(id).get();
        producto.setFecha(productoDto.getFecha());
        producto.setIdtarifa(productoDto.getIdtarifa());
        producto.setCantidad(productoDto.getCantidad());
        producto.setTotal(productoDto.getTotal());
        producto.setIdcompra(productoDto.getIdcompra());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Compra de boleto actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        Compra compra = null; 
        Producto producto = productoService.getOne(id).get();
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        List<Compra> compras = compraService.list();
        
        for(Compra item: compras){
            if (item.getId() == producto.getIdcompra()){
                compra = compraService.getOne(item.getId()).get();
                compra.setTotal(compra.getTotal()-producto.getTotal());
            }
        }
        
        compraService.save(compra);
        productoService.delete(id);
        
        return new ResponseEntity(new Mensaje("Compra de boleto eliminado"), HttpStatus.OK);
    }
}
