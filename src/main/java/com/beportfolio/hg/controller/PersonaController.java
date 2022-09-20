package com.beportfolio.hg.controller;

import com.beportfolio.hg.entity.Persona;
import com.beportfolio.hg.Interface.IPersonaService;
import com.beportfolio.hg.dto.dtoPersona;
import com.beportfolio.hg.security.controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frargpro.web.app")
public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "Creado correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "Eliminado correctamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("ubicacion") String nuevoUbicacion,
            @RequestParam("img") String nuevoImg,
            @RequestParam("fondo") String nuevoFondo) {

        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setTitulo(nuevoTitulo);
        persona.setUbicacion(nuevoUbicacion);
        persona.setImg(nuevoImg);
        persona.setFondo(nuevoFondo);

        ipersonaService.savePersona(persona);
        return persona;
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long) 3);
    }

    @PutMapping("/personas/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoPersona dtopersona) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if (ipersonaService.existByNombre(dtopersona.getNombre()) && ipersonaService.
                getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = ipersonaService.getOne(id).get();

        persona.setNombre(dtopersona.getNombre());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setUbicacion(dtopersona.getUbicacion());
        persona.setImg(dtopersona.getImg());
        persona.setFondo(dtopersona.getFondo());

        ipersonaService.savePersona(persona);

        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }

    @GetMapping("/personas/detail/{id}")
    public ResponseEntity<Persona> geyById(@PathVariable("id") Long id) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = ipersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
