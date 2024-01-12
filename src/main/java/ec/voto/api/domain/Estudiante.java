package ec.voto.api.domain;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "nombre_Completo", nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private String parelelo;
}
