
package com.beportfolio.hg.entity;

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
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String aptitudA;
    
    @NotNull
    private String valorA;
    
    @NotNull
    private String aptitudB;
    
    @NotNull
    private String valorB;
    
    @NotNull
    private String aptitudC;
    
    @NotNull
    private String valorC;
    
    @NotNull
    private String aptitudD;
    
    @NotNull
    private String valorD;
    
    @NotNull
    private String herramientaA;
    
    @NotNull
    private String valorherrA;
    
    @NotNull
    private String herramientaB;
    
    @NotNull
    private String valorherrB;
    
    @NotNull
    private String herramientaC;
    
    @NotNull
    private String valorherrC;
    
    @NotNull
    private String herramientaD;
    
    @NotNull
    private String valorherrD;
    
    @NotNull
    private String herramientaE;
    
    @NotNull
    private String valorherrE;
    
    @NotNull
    private String herramientaF;
    
    @NotNull
    private String valorherrF;
    
    //constructor

    public Skills() {
    }

    public Skills(String aptitudA, String valorA, String aptitudB, String valorB, String aptitudC, String valorC, String aptitudD, String valorD, String herramientaA, String valorherrA, String herramientaB, String valorherrB, String herramientaC, String valorherrC, String herramientaD, String valorherrD, String herramientaE, String valorherrE, String herramientaF, String valorherrF) {
        this.aptitudA = aptitudA;
        this.valorA = valorA;
        this.aptitudB = aptitudB;
        this.valorB = valorB;
        this.aptitudC = aptitudC;
        this.valorC = valorC;
        this.aptitudD = aptitudD;
        this.valorD = valorD;
        this.herramientaA = herramientaA;
        this.valorherrA = valorherrA;
        this.herramientaB = herramientaB;
        this.valorherrB = valorherrB;
        this.herramientaC = herramientaC;
        this.valorherrC = valorherrC;
        this.herramientaD = herramientaD;
        this.valorherrD = valorherrD;
        this.herramientaE = herramientaE;
        this.valorherrE = valorherrE;
        this.herramientaF = herramientaF;
        this.valorherrF = valorherrF;
    }
    
        
}
