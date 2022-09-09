
package com.beportfolio.hg.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoPersona {
        @NotBlank
    private String nombre;
    @NotBlank
    private String titulo;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String img;
    @NotBlank
    private String fondo;
   
    
    //constructor

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String titulo, String ubicacion, String img, String fondo) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.img = img;
        this.fondo = fondo;
    }
    
}
