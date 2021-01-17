package com.ec.Zoo.dto;

public class VentasDto {
    private String nombre;
    private Float total;
    private int boletos;
    public VentasDto() {
    }

    public VentasDto(String nombre, Float total, int boletos) {
        this.nombre = nombre;
        this.total = total;
        this.boletos = boletos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public int getBoletos() {
        return boletos;
    }

    public void setBoletos(int boletos) {
        this.boletos = boletos;
    }
 
}
