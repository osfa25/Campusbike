package com.example.campusbike.ventas.dominio;

import java.time.LocalDateTime;

import com.example.campusbike.clientes.dominio.Cliente;

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
@Table (name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull (message = "La fecha es obligatoria")
    @PastOrPresent (message = "La fecha de venta no puede ser futura")
    @Column (name = " fecha_venta")
    private LocalDateTime fechaVenta;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Cliente cliente;

    


}
