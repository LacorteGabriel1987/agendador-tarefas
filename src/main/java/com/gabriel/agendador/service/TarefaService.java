package com.gabriel.agendador.service;

import com.gabriel.agendador.entity.Tarefa;
import com.gabriel.agendador.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    //Get buscar todas tarefas
    public List<Tarefa> buscarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    //Get buscar por id
    public Optional<Tarefa> buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    //Post
    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    //atualizar
    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(tarefaAtualizada.getTitulo());
                    tarefa.setStatus(tarefaAtualizada.getStatus());
                    tarefa.setDescricao(tarefaAtualizada.getDescricao());
                    tarefa.setDataCriacao(tarefaAtualizada.getDataCriacao());
                    tarefa.setDataConclusao(tarefaAtualizada.getDataConclusao());
                    return tarefaRepository.save(tarefa);
                })

                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    //delete
//    public void deletarTarefa(Long id){
//        tarefaRepository.deleteById(id);
//    }

    // ou dessa forma com if
    public void deletarTarefa(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada");
        }
    }
}
