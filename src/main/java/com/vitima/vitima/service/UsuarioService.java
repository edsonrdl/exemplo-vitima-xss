package com.vitima.vitima.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitima.vitima.models.Usuario;

@Service
public class UsuarioService {
    private File jsonFile;
    private ObjectMapper objectMapper;

    public UsuarioService() throws IOException {
        ClassPathResource resource = new ClassPathResource("data.json");
        this.jsonFile = resource.getFile();
        this.objectMapper = new ObjectMapper();

        // Verifica se o arquivo "data.json" existe
        if (!jsonFile.exists()) {
            // Se o arquivo não existe, crie-o com uma lista vazia de usuários
            createEmptyJsonFile();
        }
    }

    public List<Usuario> getAll() throws IOException {
        return objectMapper.readValue(jsonFile, new TypeReference<List<Usuario>>() {});
    }

    public void insert(Usuario usuario) throws IOException {
        List<Usuario> allUsuarios = getAll();
        allUsuarios.add(usuario);
        objectMapper.writeValue(jsonFile, allUsuarios);
    }

    private void createEmptyJsonFile() throws IOException {
        // Cria o arquivo "data.json" com uma lista vazia
        objectMapper.writeValue(jsonFile, new ArrayList<Usuario>());
    }
}
