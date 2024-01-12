package ec.voto.api.domain;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String lista;

    @Column(name = "nombre_candidato", nullable = false)
    private String nombreCandidato;
}
