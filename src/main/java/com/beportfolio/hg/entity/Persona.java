
package com.beportfolio.hg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con el tamaño asignado")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con el tamaño asignado")
    private String titulo;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con el tamaño asignado")
    private String ubicacion;
    
    @NotNull
    @Size(min = 1, max = 400, message = "No cumple con el tamaño asignado")
    private String img;
}
