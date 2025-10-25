package com.gabriel.agendador.exception;

public class TarefaNotFoundException extends RuntimeException{
    public TarefaNotFoundException (Long id){
        super("Tarefa não encontrada com id " + id);
    }
}
