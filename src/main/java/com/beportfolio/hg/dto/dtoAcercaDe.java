
package com.beportfolio.hg.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoAcercaDe {
    @NotBlank
    private String sobremi;
    
     @NotBlank
    private Boolean boton;
    
     //constructor

    public dtoAcercaDe() {
    }

    public dtoAcercaDe(String sobremi, Boolean boton) {
        this.sobremi = sobremi;
        this.boton = boton;
    }
    
    
}
