package com.finan.orcamento.controller;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.UsuarioRepository;
import com.finan.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>>BuscaTodosUsuarios(){
        return ResponseEntity.ok(usuarioService.buscarUsuario());
    }
    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<UsuarioModel>buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.buscaId(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioModel>cadastraUsuario(@RequestBody UsuarioModel usuarioModel){
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioModel));
    }
    @PostMapping(path="/put/{id}")
    public ResponseEntity<UsuarioModel>atualizaUsuario(@RequestBody UsuarioModel usuarioModel, @PathVariable Long id){
        UsuarioModel usuarioNewObj=usuarioService.atualizaUsuario(usuarioModel, id);
        return ResponseEntity.ok().body(usuarioNewObj);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){
        usuarioService.deletaUsuario(id);
    }
}
