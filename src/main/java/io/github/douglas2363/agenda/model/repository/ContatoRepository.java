package io.github.douglas2363.agenda.model.repository;

import io.github.douglas2363.agenda.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
