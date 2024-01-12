package ec.voto.api.repository;

import ec.voto.api.domain.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VotacionPersistence extends JpaRepository<Votacion, Long> {

}
