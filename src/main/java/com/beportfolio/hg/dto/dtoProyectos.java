
package com.beportfolio.hg.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoProyectos {
    @NotBlank
    private String logoProyec;
    @NotBlank
    private String referenciaProyec;
    @NotBlank
    private String descripcionProyec;
    @NotBlank
    private String fechacreacionProyec;
    @NotBlank
    private String linkProyec;
    
    
    //constructor

    public dtoProyectos() {
    }

    public dtoProyectos(String referenciaProyec, String descripcionProyec, String fechacreacionProyec, String linkProyec) {
        this.referenciaProyec = referenciaProyec;
        this.descripcionProyec = descripcionProyec;
        this.fechacreacionProyec = fechacreacionProyec;
        this.linkProyec = linkProyec;
    }
    
        
}
