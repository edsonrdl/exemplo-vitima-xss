package com.vitima.vitima.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Size(min = 3, max = 15, message = "O nome não pode ter mais de 15 caracteres e menos que 3")
    @NotBlank(message = "O Nome é obrigatório e não pode estar vazio")
    private String name;


    @Size(min = 3, max = 15, message = "O password não pode ter mais de 15 caracteres e menos que 3")
    @NotBlank(message = "O password é obrigatório e não pode estar vazio")
    private String pasword;
}
