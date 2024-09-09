package com.example.campusbike.ventas.dominio;

import java.math.BigDecimal;

import com.example.campusbike.bicicleta.dominio.Bicicleta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table (name = "detalle_venta")
public class DetalleVenta {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "venta_id")
    private Ventas ventas;

    @ManyToOne
    @JoinColumn (name = "bicicleta_id")
    private Bicicleta bicicleta;

    @NotNull (message = "La cantidad es necesaria")
    @Positive (message = "La cantidad debe ser un numero positivo")
    private Integer cantidad;

    @NotNull (message = "El precio unitario es necesario")
    @Positive (message = "El precio unitario debe ser un numero positivo")
    @Column (name = "precio_unitario")
    private BigDecimal preciounitario;

    @NotNull (message = "El subtotal es obligatorio")
    @Positive (message = "El subtotal debe ser un numero positivo")
    private BigDecimal subtotal;


}
