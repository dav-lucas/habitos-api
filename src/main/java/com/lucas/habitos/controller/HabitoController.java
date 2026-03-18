package com.lucas.habitos.controller;
import com.lucas.habitos.model.Habito;
import com.lucas.habitos.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitos")
public class HabitoController {

    @Autowired
    private HabitoRepository habitoRepository;

    @GetMapping
    public List<Habito> listar() {
        return habitoRepository.findAll();
    }

    @PostMapping
    public Habito criar(@RequestBody Habito habito) {
        return habitoRepository.save(habito);
    }
}
