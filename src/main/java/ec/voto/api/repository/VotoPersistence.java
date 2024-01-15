package ec.voto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Voto;

import java.util.List;


public interface VotoPersistence extends JpaRepository<Voto, Long> {

    List<Voto> findByCandidato_NombreCandidato(String candidato);

    List<Voto> findByMesa_Id(Long id);


}
