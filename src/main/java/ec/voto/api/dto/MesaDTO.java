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
public class MesaDTO {

    private Long id;
    private int numeroMesa;
    private CursoDTO curso;
    private String votaciones;
}
