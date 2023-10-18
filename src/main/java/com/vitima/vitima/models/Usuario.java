package com.vitima.vitima.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Usuario.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    public static final String TABLE_NAME = "usuario";

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 15, nullable = false, unique = false)
    @Size(min = 3, max = 15, message = "O nome não pode ter mais de 15 caracteres e menos que 3")
    @NotBlank(message = "O Nome é obrigatório e não pode estar vazio")
    private String name;

    @Column(name = "pasword", length = 15, nullable = false, unique = false)
    @Size(min = 3, max = 15, message = "O password não pode ter mais de 15 caracteres e menos que 3")
    @NotBlank(message = "O password é obrigatório e não pode estar vazio")
    private String pasword;
}
