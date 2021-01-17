package com.ec.Zoo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PagosDto {
    @NotBlank
    private String usuario;
    @Min(0)
    private Float total;

    public PagosDto() {
    }

    public PagosDto(@NotBlank String usuario, @Min(0) Float total) {
        this.usuario = usuario;
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
}
