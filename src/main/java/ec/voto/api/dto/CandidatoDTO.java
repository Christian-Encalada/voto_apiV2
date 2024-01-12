package ec.voto.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CandidatoDTO {

    private Long id;

    private String lista;

    private String nombreCandidato;
}
