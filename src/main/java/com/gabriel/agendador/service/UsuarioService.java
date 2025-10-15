package com.gabriel.agendador.service;

import com.gabriel.agendador.entity.Usuario;
import com.gabriel.agendador.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    //GET

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    //GET ID
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

    }

    //Post
    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //PUT
    public Usuario atualizarUsuario (Long id, Usuario usuarioAtualizado){
        return usuarioRepository.findById(id)
                .map(usuario ->{
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(()->new RuntimeException("Usuario não encontrado com id"));
    }
    //Delete
    public void deletarUsuario(Long id){
        if(usuarioRepository.existsById(id)){

            usuarioRepository.deleteById(id);
        }else{
            throw new RuntimeException("Usuario não encontrado com id" + id);
        }
    }

}

