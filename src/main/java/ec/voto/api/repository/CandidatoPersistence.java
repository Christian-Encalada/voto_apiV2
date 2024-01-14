package ec.voto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Candidato;

import java.util.Optional;

public interface CandidatoPersistence extends JpaRepository<Candidato, Long> {
}
