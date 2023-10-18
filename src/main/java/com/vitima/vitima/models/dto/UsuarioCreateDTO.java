package com.vitima.vitima.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioCreateDTO {
  
    
    @Size(min = 3)
    @NotBlank()
    private String name;

    @Size(max = 15)
    private String password;
    
}
