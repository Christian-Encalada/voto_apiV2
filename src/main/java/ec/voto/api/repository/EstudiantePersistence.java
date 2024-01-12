package ec.voto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
