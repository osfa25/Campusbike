

package com.example.campusbike.bicicleta.aplicacion;

import java.util.List;
import java.util.Optional;

import com.example.campusbike.bicicleta.dominio.Bicicleta;

public interface IBicicleta {

    Optional<Bicicleta> findById(Long id);
    List<Bicicleta> getAll();
    Bicicleta save(Bicicleta bicicleta);
    Bicicleta update(Long id, Bicicleta bicicleta);
    void deleteById(Long id);
}