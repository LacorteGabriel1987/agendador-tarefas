package com.gabriel.agendador.controller;


import com.gabriel.agendador.entity.Tarefa;
import com.gabriel.agendador.entity.Usuario;
import com.gabriel.agendador.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;
    public TarefaController (TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> buscarTodasTarefas() {
        List<Tarefa> tarefas = tarefaService.buscarTodasTarefas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarTarefaPorId(id)
                .map(ResponseEntity::ok) //se encontrar retorne 200 ok + json
                .orElseGet(() -> ResponseEntity.notFound().build()); //se não, retorna 404
    }

    @PostMapping
    public ResponseEntity<Tarefa> salvarTarefa(@RequestBody Tarefa tarefa){
        Tarefa novaTarefa = tarefaService.salvarTarefa();
        return ResponseEntity.status(201).body(novaTarefa); // 201 Created + retorna a tarefa criada
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada){
        return ResponseEntity.ok(tarefaService.atualizarTarefa(id, tarefaAtualizada));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id); // se não existir, lança exceção
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}


