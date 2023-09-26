package com.softrami.practica_experto.app.service;

import com.softrami.practica_experto.app.model.Autor;
import com.softrami.practica_experto.app.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> obtenerTodsAutores(){
        return autorRepository.findAll();
    }

    public Autor obtenerAurtorPorId(Long id){
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()){
            return autor.get();
        } else {
            throw  new RuntimeException("Autor no encontrado");
        }
    }
    public Autor crearAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor actualizarAutor(Long id, Autor autorActualizado){
        Autor autorExistente = obtenerAurtorPorId(id);
        autorExistente.setNombre(autorExistente.getNombre());
        return autorRepository.save(autorActualizado);
    }

    public boolean deleteById(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
