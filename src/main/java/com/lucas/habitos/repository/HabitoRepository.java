package com.lucas.habitos.repository;
import com.lucas.habitos.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitoRepository extends JpaRepository<Habito, Long>{
}
