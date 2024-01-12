package ec.voto.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstudianteDTO {

    private Long id;

    private String nombreCompleto;

    private String parelelo;
}
