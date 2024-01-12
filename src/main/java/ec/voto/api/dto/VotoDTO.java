package ec.voto.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VotoDTO {

    private Long id;

    private EstudianteDTO estudiante;

    private CandidatoDTO candidato;

    private MesaDTO mesa;
}
