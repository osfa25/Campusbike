package com.example.campusbike.compras.dominion;

import java.math.BigDecimal;
import java.time.LocalDateTime;




import com.example.campusbike.proveedores.dominion.Proveedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de compra es obligatoria")
    @PastOrPresent(message = "La fecha de compra no puede ser futura")
    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @NotNull(message = "El total es obligatorio")
    @Column(name = "total")
    private BigDecimal total;

    
}