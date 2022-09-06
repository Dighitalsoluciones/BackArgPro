package com.beportfolio.hg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExp;
    private String descripcionExp;
    private String logoExp;
    private String desdeExp;
    private String hastaExp;

    //Crear Constructor
    public Experiencia() {
    }

    public Experiencia(String nombreExp, String descripcionExp, String logoExp, String desdeExp, String hastaExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.logoExp = logoExp;
        this.desdeExp = desdeExp;
        this.hastaExp = hastaExp;
    }

    //Crear Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
