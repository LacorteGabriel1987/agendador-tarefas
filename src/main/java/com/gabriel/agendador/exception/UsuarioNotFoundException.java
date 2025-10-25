package com.gabriel.agendador.exception;


public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException (Long id){
        super("Usuario não encontrado com id " + id);
    }
}
