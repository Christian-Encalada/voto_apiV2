package ec.voto.api.repository;

import ec.voto.api.dto.EstudianteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Estudiante;

import java.util.List;

public interface EstudiantePersistence extends JpaRepository<Estudiante, Long> {

    List<EstudianteDTO> findByCurso(Long idCurso);

}
