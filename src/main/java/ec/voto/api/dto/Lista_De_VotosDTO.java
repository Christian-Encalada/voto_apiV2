package ec.voto.api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class Lista_De_VotosDTO {

    private Long id;
    private VotacionDTO votacion;
    private String asistencia;
}
