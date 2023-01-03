package edu.da.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contactos")
@NoArgsConstructor
@Getter
@Setter
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long imagen;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private String domicilio;
}
