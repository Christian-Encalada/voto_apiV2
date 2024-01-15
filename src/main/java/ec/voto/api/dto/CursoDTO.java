package ec.voto.api.dto;

import ec.voto.api.domain.Estudiante;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@MappedSuperclass
@Getter
@Setter
@ToString

public class CursoDTO {

    private Long id;

    private String curso;

    private List<Estudiante> estudiantes;


}
