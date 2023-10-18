package com.vitima.vitima.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitima.vitima.models.Usuario;
import com.vitima.vitima.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired
    private  UsuarioService usuarioService;

    
    @GetMapping
    public List<Usuario> getAllUsuarios() throws IOException {
        return usuarioService.getAll();
    }

    @PostMapping
    public void createUsuario(@RequestBody Usuario usuario) throws IOException {
        usuarioService.insert(usuario);
    }

    
}
