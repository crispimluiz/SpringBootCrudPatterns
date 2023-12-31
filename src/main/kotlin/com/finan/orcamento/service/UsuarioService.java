package com.finan.orcamento.service;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarUsuario(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel buscaId(Long id){
        Optional<UsuarioModel>obj=usuarioRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel atualizaUsuario(UsuarioModel usuarioModel, Long id){
        UsuarioModel newUsuarioModel = buscaId(id);
        newUsuarioModel.setNomeUsuario(usuarioModel.getNomeUsuario());
        return usuarioRepository.save(newUsuarioModel);
    }
    public void deletaUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
