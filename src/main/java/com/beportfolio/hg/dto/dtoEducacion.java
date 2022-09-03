
package com.beportfolio.hg.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String logo;
    @NotBlank
    private String centroeduc;
    @NotBlank
    private String desde;
    @NotBlank
    private String hasta;
    @NotBlank
    private String ubicacion;
    
    //constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String logo, String centroeduc, String desde, String hasta, String ubicacion) {
        this.titulo = titulo;
        this.logo = logo;
        this.centroeduc = centroeduc;
        this.desde = desde;
        this.hasta = hasta;
        this.ubicacion = ubicacion;
    }
    
}
