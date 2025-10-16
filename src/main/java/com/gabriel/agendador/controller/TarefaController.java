package com.gabriel.agendador.controller;


import com.gabriel.agendador.entity.Tarefa;
import com.gabriel.agendador.entity.Usuario;
import com.gabriel.agendador.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;
    public TarefaController (TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity List<Tarefa>>buscarTodasTarefas(){
        List <Tarefa> tarefas = tarefaService.buscarTodasTarefas();
        return ResponseEntity.ok(tarefas);
    }


}
