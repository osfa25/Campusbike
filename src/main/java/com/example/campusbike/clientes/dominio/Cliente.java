package com.example.campusbike.clientes.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "clientes")
public class Cliente {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;
    @Column(columnDefinition = "BIGINT", nullable = false)
    private Long telefono;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

 @ManyToOne
    private Ciudades ciudades ;
    
     

    
}
