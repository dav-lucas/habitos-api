package com.lucas.habitos.service;

import com.lucas.habitos.model.Habito;
import com.lucas.habitos.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitoService {

    @Autowired
    private HabitoRepository repository;

    public List<Habito> listarTodos() {
        return repository.findAll();
    }

    public Habito buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado!"));
    }

    public Habito salvar(Habito habito) {
        return repository.save(habito);
    }

    public void excluir(Long id) {

       Habito habito = repository.findById(id)
                       .orElseThrow(() -> new RuntimeException("Hábito não encontrado para exclusão!"));

        repository.delete(habito);
    }

    public Habito atualizar(Long id, Habito dadosAtualizados) {
        Habito habitoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado!"));

        habitoExistente.setNome(dadosAtualizados.getNome());
        habitoExistente.setDias(dadosAtualizados.getDias());

        return repository.save(habitoExistente);
    }
}
