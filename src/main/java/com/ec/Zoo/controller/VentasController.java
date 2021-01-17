package com.ec.Zoo.controller;

import com.ec.Zoo.dto.Mensaje;
import com.ec.Zoo.entity.Compra;
import com.ec.Zoo.entity.Ventas;
import com.ec.Zoo.service.CompraService;
import com.ec.Zoo.service.VentasService;
import com.ec.Zoo.dto.VentasDto;
import com.ec.Zoo.entity.Producto;
import com.ec.Zoo.service.ProductoService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*")
public class VentasController {
    @Autowired
    CompraService compraService;
    
    @Autowired
    VentasService ventasService;
    
    @Autowired
    ProductoService productoService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista")
    public ResponseEntity<List<Ventas>> list(){
        List<Ventas> list = ventasService.list();
        List<Compra> compras = compraService.list();
        List<Producto> productos = productoService.list();
        Date fecha;
        Calendar calendar = Calendar.getInstance();
        float total1 = 0;
        float total2 = 0;
        float total3 = 0;
        float total4 = 0;
        float total5 = 0;
        float total6 = 0;
        float total7 = 0;
        float total8 = 0;
        float total9 = 0;
        float total10 = 0;
        float total11 = 0;
        float total12 = 0;
        
        int boletos1 = 0;
        int boletos2 = 0;
        int boletos3 = 0;
        int boletos4 = 0;
        int boletos5 = 0;
        int boletos6 = 0;
        int boletos7 = 0;
        int boletos8 = 0;
        int boletos9 = 0;
        int boletos10 = 0;
        int boletos11 = 0;
        int boletos12 = 0;
        
        Ventas venta;
        
        for(Ventas item : list){
            venta = ventasService.getOne(item.getMes()).get();
            venta.setTotal(0);
            venta.setBoletos(0);
            ventasService.save(venta);
        }
        
        for(Compra str : compras)
        {
            fecha = str.getFecha();
            calendar.setTime(fecha);
            
            if(calendar.get(Calendar.MONTH) + 1 == 1){
                total1 = total1 + str.getTotal();             
                venta = ventasService.getOne(1).get();
                venta.setTotal(total1);           
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos1 = boletos1 + item.getCantidad();
                        venta.setBoletos(boletos1);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 2){
                total2 = total2 + str.getTotal();
                venta = ventasService.getOne(2).get();
                venta.setTotal(total2);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos2 = boletos2 + item.getCantidad();
                        venta.setBoletos(boletos2);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 3){
                total3 = total3 + str.getTotal();
                venta = ventasService.getOne(3).get();
                venta.setTotal(total3);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos3 = boletos3 + item.getCantidad();
                        venta.setBoletos(boletos3);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 4){
                total4 = total4 + str.getTotal();
                venta = ventasService.getOne(4).get();
                venta.setTotal(total4);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos4 = boletos4 + item.getCantidad();
                        venta.setBoletos(boletos4);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 5){
                total5 = total5 + str.getTotal();
                venta = ventasService.getOne(5).get();
                venta.setTotal(total5);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos5 = boletos5 + item.getCantidad();
                        venta.setBoletos(boletos5);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 6){
                total6 = total6 + str.getTotal();
                venta = ventasService.getOne(6).get();
                venta.setTotal(total6);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos6 = boletos6 + item.getCantidad();
                        venta.setBoletos(boletos6);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 7){
                total7 = total7 + str.getTotal();
                venta = ventasService.getOne(7).get();
                venta.setTotal(total7);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos7 = boletos7 + item.getCantidad();
                        venta.setBoletos(boletos7);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 8){
                total8 = total8 + str.getTotal();
                venta = ventasService.getOne(8).get();
                venta.setTotal(total8);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos8 = boletos8 + item.getCantidad();
                        venta.setBoletos(boletos8);
                    }
                }
                ventasService.save(venta);
            }
            
            if(calendar.get(Calendar.MONTH) + 1 == 9){
                total9 = total9 + str.getTotal();
                venta = ventasService.getOne(9).get();
                venta.setTotal(total9);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos9 = boletos9 + item.getCantidad();
                        venta.setBoletos(boletos9);
                    }
                }
                ventasService.save(venta);
            }
            if(calendar.get(Calendar.MONTH) + 1 == 10){
                total10 = total10 + str.getTotal();
                venta = ventasService.getOne(10).get();
                venta.setTotal(total10);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos10 = boletos10 + item.getCantidad();
                        venta.setBoletos(boletos10);
                    }
                }
                ventasService.save(venta);
            }
            if(calendar.get(Calendar.MONTH) + 1 == 11){
                total11 = total11 + str.getTotal();
                venta = ventasService.getOne(11).get();
                venta.setTotal(total11);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos11 = boletos11 + item.getCantidad();
                        venta.setBoletos(boletos11);
                    }
                }
                ventasService.save(venta);
            }
            if(calendar.get(Calendar.MONTH) + 1 == 12){
                total12 = total12 + str.getTotal();
                venta = ventasService.getOne(12).get();
                venta.setTotal(total12);
                
                for(Producto item : productos){
                    if (item.getIdcompra() == str.getId()){
                        boletos12 = boletos12 + item.getCantidad();
                        venta.setBoletos(boletos12);
                    }
                }
                ventasService.save(venta);
            }
        }
              
        return new ResponseEntity(list, HttpStatus.OK);
    }
   
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Ventas> getById(@PathVariable("id") int id){
        List<Ventas> ventas = ventasService.list();
        Ventas venta = new Ventas ("null", 0, 0);
        Ventas venta2 = new Ventas ("null", 10000, 10000);
        Ventas ventas3 = null;
        
        if(id == 13){
            for(Ventas item: ventas){
                if(item.getTotal() > venta.getTotal()){
                    venta = item;
                }
            }
            ventas3 = ventasService.getOne(venta.getMes()).get();
        }
        
        if(id == 14){
            for(Ventas item: ventas){
                if(item.getTotal() < venta2.getTotal()){
                    venta2 = item;
                }
            }
            ventas3 = ventasService.getOne(venta2.getMes()).get();
        } 
        
        if(id != 13 && id !=14){
            ventas3 = ventasService.getOne(id).get();
        }
        
        return new ResponseEntity(ventas3, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/message/{mes1}/{mes2}")
    public String mensaje(@PathVariable("mes1") int mes1, @PathVariable("mes2") int mes2){
        Ventas venta = ventasService.getOne(mes1).get();
        int i = mes1+1;
        
        while(i<=mes2){
            if(ventasService.getOne(i).get().getTotal() > venta.getTotal()){
                venta = ventasService.getOne(i).get();
            }
            i++;
        }            
        
        return "El mes con más ventas fue: " + venta.getNombre().toString().toUpperCase()
                + ", Total $ vendido: $" + String.valueOf(venta.getTotal())
                + ", Total boletos vendidos: " + Integer.toString(venta.getBoletos());
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/message2/{mes1}/{mes2}")
    public String mensaje2(@PathVariable("mes1") int mes1, @PathVariable("mes2") int mes2){
        Ventas venta = ventasService.getOne(mes1).get();
        int i = mes1+1;
        
        while(i<=mes2){
            if(ventasService.getOne(i).get().getTotal() < venta.getTotal()){
                venta = ventasService.getOne(i).get();
            }
            i++;
        }            
        
        return "El mes con menos ventas fue: " + venta.getNombre().toString().toUpperCase()
                + ", Total $ vendido: $" + String.valueOf(venta.getTotal())
                + ", Total boletos vendidos: " + Integer.toString(venta.getBoletos());
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/message3/{mes1}/{mes2}")
    public String mensaje3(@PathVariable("mes1") int mes1, @PathVariable("mes2") int mes2){
        Ventas venta = ventasService.getOne(mes1).get();
        int i = mes1+1;
        
        while(i<=mes2){
            if(ventasService.getOne(i).get().getBoletos() > venta.getBoletos()){
                venta = ventasService.getOne(i).get();
            }
            i++;
        }            
        
        return "El mes con más ventas fue: " + venta.getNombre().toString().toUpperCase()
                + ", Total boletos vendidos: " + Integer.toString(venta.getBoletos())
                + ", Total $ vendido: $" + String.valueOf(venta.getTotal());
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/message4/{mes1}/{mes2}")
    public String mensaje4(@PathVariable("mes1") int mes1, @PathVariable("mes2") int mes2){
        Ventas venta = ventasService.getOne(mes1).get();
        int i = mes1+1;
        
        while(i<=mes2){
            if(ventasService.getOne(i).get().getBoletos() < venta.getBoletos()){
                venta = ventasService.getOne(i).get();
            }
            i++;
        }            
        
        return "El mes con menos ventas fue: " + venta.getNombre().toString().toUpperCase()
                + ", Total boletos vendidos: " + Integer.toString(venta.getBoletos())
                + ", Total $ vendido: $" + String.valueOf(venta.getTotal());
    }
}
