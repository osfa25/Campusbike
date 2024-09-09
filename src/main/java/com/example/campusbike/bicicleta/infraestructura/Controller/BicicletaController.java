package com.example.campusbike.bicicleta.infraestructura.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.campusbike.bicicleta.aplicacion.IBicicleta;
import com.example.campusbike.bicicleta.dominio.Bicicleta;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {

    @Autowired
    private IBicicleta bicicletaService;

    @GetMapping
    public ResponseEntity<List<Bicicleta>> list() {
        List<Bicicleta> bicicletas = bicicletaService.getAll();
        return new ResponseEntity<>(bicicletas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicicleta> show(@PathVariable Long id) {
        return bicicletaService.findById(id)
                .map(bicicleta -> new ResponseEntity<>(bicicleta, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Bicicleta> create(@RequestBody Bicicleta bicicleta) {
        Bicicleta createdBicicleta = bicicletaService.save(bicicleta);
        return new ResponseEntity<>(createdBicicleta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicleta> update(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
        Bicicleta updatedBicicleta = bicicletaService.update(id, bicicleta);
        if (updatedBicicleta != null) {
            return new ResponseEntity<>(updatedBicicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bicicletaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}