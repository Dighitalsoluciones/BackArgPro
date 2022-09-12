
package com.beportfolio.hg.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoSkills {
    @NotBlank
    private String aptitudA;
    
    @NotBlank
    private String valorA;
    
    @NotBlank
    private String aptitudB;
    
    @NotBlank
    private String valorB;
    
    @NotBlank
    private String aptitudC;
    
    @NotBlank
    private String valorC;
    
    @NotBlank
    private String aptitudD;
    
    @NotBlank
    private String valorD;
    
    @NotBlank
    private String herramientaA;
    
    @NotBlank
    private String valorherrA;
    
    @NotBlank
    private String herramientaB;
    
    @NotBlank
    private String valorherrB;
    
    @NotBlank
    private String herramientaC;
    
    @NotBlank
    private String valorherrC;
    
    @NotBlank
    private String herramientaD;
    
    @NotBlank
    private String valorherrD;
    
    @NotBlank
    private String herramientaE;
    
    @NotBlank
    private String valorherrE;
    
    @NotBlank
    private String herramientaF;
    
    @NotBlank
    private String valorherrF;
    
    //constructor

    public dtoSkills() {
    }

    public dtoSkills(String aptitudA, String valorA, String aptitudB, String valorB, String aptitudC, String valorC, String aptitudD, String valorD, String herramientaA, String valorherrA, String herramientaB, String valorherrB, String herramientaC, String valorherrC, String herramientaD, String valorherrD, String herramientaE, String valorherrE, String herramientaF, String valorherrF) {
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
