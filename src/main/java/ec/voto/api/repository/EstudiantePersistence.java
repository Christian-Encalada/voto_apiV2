package ec.voto.api.repository;

import ec.voto.api.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Estudiante;

import java.util.List;

public interface EstudiantePersistence extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByAsistencia(Boolean asistencia);

}
