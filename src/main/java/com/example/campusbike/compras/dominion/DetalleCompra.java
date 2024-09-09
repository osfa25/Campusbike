package com.example.campusbike.compras.dominion;

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
@Table(name = "detalle_compras")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicleta;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser un número positivo")
    private Integer cantidad;

    @NotNull(message = "El precio unitario es obligatorio")
    @Positive(message = "El precio unitario debe ser un número positivo")
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @NotNull(message = "El subtotal es obligatorio")
    @Positive(message = "El subtotal debe ser un número positivo")
    private BigDecimal subtotal;  


}
