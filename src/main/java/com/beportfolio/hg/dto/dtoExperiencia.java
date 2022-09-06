
package com.beportfolio.hg.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    @Column(name = "logo", nullable = false, length = 450)
    private String descripcionExp;
    @NotBlank
    private String logoExp;
    @NotBlank
    private String desdeExp;
    @NotBlank
    private String hastaExp;
    
    
    //Crear Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String descripcionExp, String logoExp, String desdeExp, String hastaExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.logoExp = logoExp;
        this.desdeExp = desdeExp;
        this.hastaExp = hastaExp;
    }
    //crear getter y setter

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getLogoExp() {
        return logoExp;
    }

    public void setLogoExp(String logoExp) {
        this.logoExp = logoExp;
    }

    public String getDesdeExp() {
        return desdeExp;
    }

    public void setDesdeExp(String desdeExp) {
        this.desdeExp = desdeExp;
    }

    public String getHastaExp() {
        return hastaExp;
    }

    public void setHastaExp(String hastaExp) {
        this.hastaExp = hastaExp;
    }
    
    
    
        
}
