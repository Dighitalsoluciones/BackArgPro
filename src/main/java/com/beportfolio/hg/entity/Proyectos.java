
package com.beportfolio.hg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "logoProyec", nullable = false, length = 450)
    private String logoProyec;
    
    @NotNull
    private String referenciaProyec;
    
    @NotNull
    private String descripcionProyec;
    
    @NotNull
    private String fechacreacionProyec;
    
    @NotNull
     @Column(name = "linkProyec", nullable = false, length = 450)
    private String linkProyec;
        
    //Constructor

    public Proyectos() {
    }

    public Proyectos(String logoProyec, String referenciaProyec, String descripcionProyec, String fechacreacionProyec, String linkProyec) {
        this.logoProyec = logoProyec;
        this.referenciaProyec = referenciaProyec;
        this.descripcionProyec = descripcionProyec;
        this.fechacreacionProyec = fechacreacionProyec;
        this.linkProyec = linkProyec;
    }
    
    
    
    
}
