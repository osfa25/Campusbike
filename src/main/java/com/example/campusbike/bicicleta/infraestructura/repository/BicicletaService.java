package com.example.campusbike.bicicleta.infraestructura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campusbike.bicicleta.aplicacion.IBicicleta;
import com.example.campusbike.bicicleta.dominio.Bicicleta;

@Service
public class BicicletaService implements IBicicleta {
    
    @Autowired
    private BicicletasRepository bicicletaRepository;

    @Override
    public Optional<Bicicleta> findById(Long id) {
        return BicicletasRepository.findById(id);
    }

    @Override
    public List<Bicicleta> getAll() {
        return bicicletaRepository.findAll();
    }

    @Override
    public Bicicleta save(Bicicleta bicicleta) {
        return BicicletasRepository.save(bicicleta);
    }

    @Override
    public Bicicleta update(Long id, Bicicleta bicicleta) {
        Optional<Bicicleta> bicicletaOptional = BicicletasRepository.findById(id);

        if (bicicletaOptional.isPresent()) {
            Bicicleta bicicletaToUpdate = bicicletaOptional.get();
            bicicletaToUpdate.setModelo(bicicleta.getModelo());
            bicicletaToUpdate.setMarca(bicicleta.getMarca());
            bicicletaToUpdate.setPrecio(bicicleta.getPrecio());
            return BicicletasRepository.save(bicicletaToUpdate);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        BicicletasRepository.deleteById(id);
    }
}