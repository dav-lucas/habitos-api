package com.lucas.habitos.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import  jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio")
    @Schema(example = "Beber 2L de água")
    private String nome;

    @NotNull(message = "Os dias são obrigatórios")
    @Min(value = 0,message = "Os dias devem ser 0 ou mais")
    @Schema(example = "21")
    private Integer metaDeDias;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dataInicio = LocalDate.now();

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMetaDeDias() {
        return metaDeDias;
    }

    public void setMetaDeDias(Integer metaDeDias) {
        this.metaDeDias = metaDeDias;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
