package com.vitima.vitima.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitima.vitima.models.Usuario;
import com.vitima.vitima.models.dto.UsuarioCreateDTO;
import com.vitima.vitima.repositores.UsuarioRepository;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName(), null));
    }

    @Transactional
    public Usuario create(UsuarioCreateDTO dto) {
        Usuario client = new Usuario();
        client.setName(dto.getName());
        client.setPasword(dto.getPassword());
        return this.usuarioRepository.save(client);
    }
    
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

}
