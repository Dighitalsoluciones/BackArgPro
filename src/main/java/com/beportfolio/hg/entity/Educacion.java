
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
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "logo", nullable = false, length = 450)
    private String logo;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String centroeduc;
    
    @NotNull
    private String desde;
    
    @NotNull
    private String hasta;
    
    @NotNull
    private String ubicacion;
    
    //Constructores

    public Educacion() {
    }

    public Educacion(String logo, String titulo, String centroeduc, String desde, String hasta, String ubicacion) {
        this.logo = logo;
        this.titulo = titulo;
        this.centroeduc = centroeduc;
        this.desde = desde;
        this.hasta = hasta;
        this.ubicacion = ubicacion;
    }
    
   
    
    
    
    
}
