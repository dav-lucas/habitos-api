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
        return repository.findById(id).orElse(null);
    }

    public Habito salvar(Habito habito) {
        return repository.save(habito);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
