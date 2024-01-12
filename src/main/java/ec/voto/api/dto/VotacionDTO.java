package ec.voto.api.dto;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@MappedSuperclass
@Getter
@Setter
@ToString
public class VotacionDTO {
    private Long id;
    private EstudianteDTO estudiante;
    private MesaDTO mesa;
    private String listas_de_votos;

}
