package com.lucas.habitos.controller;

import com.lucas.habitos.model.Habito;
import com.lucas.habitos.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitos")
public class HabitoController {

    @Autowired
    private HabitoService service;

    @GetMapping
    public List<Habito> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habito> buscar(@PathVariable Long id) {
        try {
            Habito habito = service.buscarPorId(id);
            return ResponseEntity.ok(habito);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Habito criar(@RequestBody Habito habito) {
        return service.salvar(habito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habito> atualizar(@PathVariable Long id, @RequestBody Habito habito) {
        try {
            Habito atualizado = service.atualizar(id, habito);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
