package com.ec.Zoo.dto;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductoDto {

    @NotBlank
    private Date fecha;
    @Min(0)
    private int idtarifa;
    @Min(0)
    private int cantidad;
    @Min(0)
    private Float total;
    @Min(0)
    private int idcompra;

    public ProductoDto() {
    }

    public ProductoDto(@NotBlank Date fecha, @Min(0) int idtarifa, @Min(0) int cantidad, @Min(0) Float total, @Min(0) int idcompra) {
        this.fecha = fecha;
        this.idtarifa = idtarifa;
        this.cantidad = cantidad;
        this.total = total;
        this.idcompra = idcompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(int idtarifa) {
        this.idtarifa = idtarifa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

}
