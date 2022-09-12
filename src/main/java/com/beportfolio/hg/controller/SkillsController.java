
package com.beportfolio.hg.controller;

import com.beportfolio.hg.dto.dtoSkills;
import com.beportfolio.hg.entity.Skills;
import com.beportfolio.hg.security.controller.Mensaje;
import com.beportfolio.hg.service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
    
    @Autowired()
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> geyById(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills) {
        if (StringUtils.isBlank(dtoskills.getAptitudA())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorA())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskills.getAptitudB())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorB())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskills.getAptitudC())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorC())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskills.getAptitudD())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorD())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskills.getHerramientaA())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorherrA())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.isBlank(dtoskills.getHerramientaB())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorherrB())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.isBlank(dtoskills.getHerramientaC())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorherrC())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.isBlank(dtoskills.getHerramientaD())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorherrD())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.isBlank(dtoskills.getHerramientaE())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorherrE())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.isBlank(dtoskills.getHerramientaF())) {
            return new ResponseEntity(new Mensaje("campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoskills.getValorherrF())) {
            return new ResponseEntity(new Mensaje("Valor Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(
                dtoskills.getAptitudA(), dtoskills.getValorA(),dtoskills.getAptitudB(), dtoskills.getValorB(),dtoskills.getAptitudC(), dtoskills.getValorC(),
                dtoskills.getAptitudD(), dtoskills.getValorD(),dtoskills.getHerramientaA(), dtoskills.getValorherrA(),dtoskills.getHerramientaB(), dtoskills.getValorherrB(),
                dtoskills.getHerramientaC(), dtoskills.getValorherrC(),dtoskills.getHerramientaD(), dtoskills.getValorherrD(),dtoskills.getHerramientaE(), dtoskills.getValorherrE(),
                dtoskills.getHerramientaF(), dtoskills.getValorherrF());
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Nuevo objeto creado exitosamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sSkills.existByAptitudA(dtoskills.getAptitudA()) && sSkills.
                getByAptitudA(dtoskills.getAptitudA()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Proyecto existente"), HttpStatus.BAD_REQUEST);
    }
        if(StringUtils.isBlank(dtoskills.getAptitudA())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorA())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getAptitudB())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorB())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getAptitudC())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorC())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getAptitudD())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorD())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getHerramientaA())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorherrA())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getHerramientaB())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorherrB())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getHerramientaC())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorherrC())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getHerramientaD())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorherrD())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getHerramientaE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorherrE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getHerramientaF())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getValorherrF())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        
        
        Skills skills = sSkills.getOne(id).get();
        
        skills.setAptitudA(dtoskills.getAptitudA());
        skills.setValorA(dtoskills.getValorA());
        skills.setAptitudB(dtoskills.getAptitudB());
        skills.setValorB(dtoskills.getValorB());
        skills.setAptitudC(dtoskills.getAptitudC());
        skills.setValorC(dtoskills.getValorC());
        skills.setAptitudD(dtoskills.getAptitudD());
        skills.setValorD(dtoskills.getValorD());
        skills.setHerramientaA(dtoskills.getHerramientaA());
        skills.setValorherrA(dtoskills.getValorherrA());
        skills.setHerramientaB(dtoskills.getHerramientaB());
        skills.setValorherrB(dtoskills.getValorherrB());
        skills.setHerramientaC(dtoskills.getHerramientaC());
        skills.setValorherrC(dtoskills.getValorherrC());
        skills.setHerramientaD(dtoskills.getHerramientaD());
        skills.setValorherrD(dtoskills.getValorherrD());
        skills.setHerramientaE(dtoskills.getHerramientaE());
        skills.setValorherrE(dtoskills.getValorherrE());
        skills.setHerramientaF(dtoskills.getHerramientaF());
        skills.setValorherrF(dtoskills.getValorherrF());
        
        sSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }
    
}
