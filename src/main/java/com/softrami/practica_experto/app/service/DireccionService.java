package com.softrami.practica_experto.app.service;

import com.softrami.practica_experto.app.model.Direccion;
import com.softrami.practica_experto.app.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public List<Direccion> obtenerDirecciones(){
        return direccionRepository.findAll();
    }

    public Direccion obtenerDireccionPorId(Long id){
        Optional<Direccion> autor = direccionRepository.findById(id);
        if (autor.isPresent()){
            return autor.get();
        } else {
            throw  new RuntimeException("Autor no encontrado");
        }
    }
    public Direccion crearDireccion(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public Direccion actualizarDireccion(Long id, Direccion direccionActualizado){
        Direccion direccionExistente = obtenerDireccionPorId(id);
        direccionExistente.setCalle(direccionExistente.getCalle());
        /*Pendiente validar*/
        return direccionRepository.save(direccionActualizado);
    }
}
