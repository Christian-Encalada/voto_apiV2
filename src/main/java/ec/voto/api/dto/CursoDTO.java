package ec.voto.api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@MappedSuperclass
@Getter
@Setter
@ToString
public class CursoDTO {
   private long id;
   private String nombre_del_Curso;

    public CursoDTO() {
    }
}
