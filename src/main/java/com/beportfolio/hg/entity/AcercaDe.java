
package com.beportfolio.hg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@Entity
public class AcercaDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    private String sobremi;
    
    private Boolean boton;

   //constructor

    public AcercaDe() {
    }

    public AcercaDe(String sobremi, Boolean boton) {
        this.sobremi = sobremi;
        this.boton = boton;
    }
    
}
