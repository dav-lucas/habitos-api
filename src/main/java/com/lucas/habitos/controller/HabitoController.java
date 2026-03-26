package com.lucas.habitos.controller;

import com.lucas.habitos.model.Habito;
import com.lucas.habitos.service.HabitoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    public Habito criar(@Valid @RequestBody Habito habito) {
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
    public ResponseEntity<Habito> atualizar(@PathVariable Long id, @Valid @RequestBody Habito habito) {
        try {
            Habito atualizado = service.atualizar(id, habito);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @Operation(summary = "Calcula o progresso do hábito", description = "Retorna quantos dias se passaram desde a criação")
    @GetMapping("/{id}/progresso")
    public ResponseEntity<String> verProgresso(@PathVariable Long id) {
        try {
            Long diasPassados = service.calcularProgresso(id);
            Habito h = service.buscarPorId(id);

            String mensagem;

            if (diasPassados >= h.getMetaDeDias()) {
                mensagem = String.format(
                        "Parabéns! Você consolidou o hábito '%s'! " +
                                "Meta de %d dias atingida. Você está firme há %d dias!",
                        h.getNome(), h.getMetaDeDias(), diasPassados
                );
            } else {
                long faltam = h.getMetaDeDias() - diasPassados;
                mensagem = String.format(
                        "Hábito: %s | Você está firme há %d dias! " +
                                "Faltam apenas %d dias para bater sua meta de %d.",
                        h.getNome(), diasPassados, faltam, h.getMetaDeDias()
                );
            }

            return ResponseEntity.ok(mensagem);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
