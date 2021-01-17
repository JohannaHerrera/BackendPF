package com.ec.Zoo.controller;

import com.ec.Zoo.dto.Mensaje;
import com.ec.Zoo.dto.PagosDto;
import com.ec.Zoo.entity.Compra;
import com.ec.Zoo.entity.Pagos;
import com.ec.Zoo.service.CompraService;
import com.ec.Zoo.service.PagosService;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "*")
public class PagosController {
    @Autowired
    PagosService pagosService;
    
    @Autowired
    CompraService compraService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista")
    public ResponseEntity<List<Pagos>> list(){
        List<Pagos> list = pagosService.list();
        List<Compra> compras = compraService.list();
        Pagos pago;
        int usuario = 0;
        float total1 = 0;
        float total2 = 0;
        float total3 = 0;
        
        for(Pagos item: list){
            if(item.getUsuario().equals("johanna2")){
                usuario = 2;
                for(Compra compra: compras){
                    if(compra.getIdusuario() == usuario){
                        total1 = total1 + compra.getTotal();
                    }
                }
                pago = pagosService.getOne(item.getId()).get();
                pago.setTotal(total1);
                pagosService.save(pago);
            }
            if(item.getUsuario().equals("prueba")){
                usuario = 3;
                for(Compra compra: compras){
                    if(compra.getIdusuario() == usuario){
                        total2 = total2 + compra.getTotal();
                    }
                }
                pago = pagosService.getOne(item.getId()).get();
                pago.setTotal(total2);
                pagosService.save(pago);
            }
            if(item.getUsuario().equals("johanna")){
                usuario = 1;
                for(Compra compra: compras){
                    if(compra.getIdusuario() == usuario){
                        total3 = total3 + compra.getTotal();                        
                    }
                }
                pago = pagosService.getOne(item.getId()).get();
                pago.setTotal(total3);
                pagosService.save(pago);
            }
        }
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
}
