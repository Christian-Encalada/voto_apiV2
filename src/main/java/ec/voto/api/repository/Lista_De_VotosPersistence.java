package ec.voto.api.repository;

import ec.voto.api.domain.Lista_De_Votos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Lista_De_VotosPersistence extends JpaRepository<Lista_De_Votos, Long> {

}
