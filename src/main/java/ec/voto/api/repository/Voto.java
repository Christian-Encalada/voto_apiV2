package ec.voto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {

}
