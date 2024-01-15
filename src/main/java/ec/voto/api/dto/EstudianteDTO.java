package ec.voto.api.dto;

import ec.voto.api.domain.Curso;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class EstudianteDTO {

    private Long id;

    private String nombreCompleto;

    private String paralelo;

    private Curso curso;

    private Boolean asistencia;


}
