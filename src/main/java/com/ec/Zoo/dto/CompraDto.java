package com.ec.Zoo.dto;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CompraDto {
    @NotBlank
    private Date fecha;
    @Min(0)
    private Float total;
    @NotBlank
    private String observacion;
    @Min(0)
    private int idusuario;
    
    public CompraDto() {
    }

    public CompraDto(@NotBlank Date fecha, @Min(0) Float total, @NotBlank String observacion, @Min(0) int idusuario) {
        this.fecha = fecha;
        this.total = total;
        this.observacion = observacion;
        this.idusuario = idusuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

}
