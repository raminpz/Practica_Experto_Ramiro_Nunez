package com.softrami.practica_experto.app.service;

import com.softrami.practica_experto.app.model.Libro;
import com.softrami.practica_experto.app.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerLibros(){
        return libroRepository.findAll();
    }

    public Libro obtenerLibroPorId(Long id){
        Optional<Libro> libro = libroRepository.findById(id);
        if (libro.isPresent()){
            return libro.get();
        } else {
            throw new RuntimeException("Libro no encontrado con ID: "+ id);
        }
    }

    public Libro crearLibro(Libro libro){

        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroActualizado){
        Libro libroExistente = obtenerLibroPorId(id);

        libroExistente.setTitulo(libroActualizado.getTitulo());

        return libroRepository.save(libroExistente);

    }
}
