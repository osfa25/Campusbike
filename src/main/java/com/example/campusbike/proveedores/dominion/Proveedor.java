package com.example.campusbike.proveedores.dominion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table (name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombrede la empresa es obligatorio")
    @Column (name = "nombre_empresa")
    private String nombre_empresa;

    @NotBlank(message = "El nombre del contacto es obligatorio")
    @Column (name = "nombre_contacto")
    private String nombre_contacto;

    @Email (message = "El email debe ser valido")
    private String email;

    private String telefono;

    private String ciudad;



}
