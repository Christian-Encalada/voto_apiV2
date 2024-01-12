package ec.voto.api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mesa")

public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "num_mesa", nullable = false)
    private int num_mesa;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

}
