package com.softrami.practica_experto.app.service;

import com.softrami.practica_experto.app.model.Persona;
import com.softrami.practica_experto.app.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;


    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> obtenerPersonas(){
        return personaRepository.findAll();
    }

    public Persona obtenerPersonaPorId(Long id){
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()){
            return persona.get();
        } else {
            throw new RuntimeException("Persona no encontrado con ID: "+ id);
        }
    }

    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(Long id, Persona personaActualizado){
        Persona personaExistente = obtenerPersonaPorId(id);
        personaExistente.setNombre(personaExistente.getNombre());

        return personaRepository.save(personaExistente);
    }
}
