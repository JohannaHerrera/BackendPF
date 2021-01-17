package com.ec.Zoo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class TarifaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @Min(0)
    private Float precio;

    public TarifaDto() {
    }

    public TarifaDto(@NotBlank String nombre, @NotBlank String descripcion, @Min(0) Float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
}
