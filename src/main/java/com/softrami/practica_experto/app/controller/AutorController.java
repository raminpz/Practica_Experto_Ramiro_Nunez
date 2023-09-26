package com.softrami.practica_experto.app.controller;

import com.softrami.practica_experto.app.model.Autor;
import com.softrami.practica_experto.app.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarAutores(){
        return autorService.obtenerTodsAutores();
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor){
        Autor nuevoAutor = autorService.crearAutor(autor);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable Long id){
        Autor autor = autorService.obtenerAurtorPorId(id);
        return ResponseEntity.ok(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, @RequestBody Autor autorActuzalizado){
        Autor autor = autorService.actualizarAutor(id,autorActuzalizado);
        return ResponseEntity.ok(autor);
    }
}
