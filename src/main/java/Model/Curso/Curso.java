package Model.Curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="cursos")
@Entity(name="Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicos_id")
    @NotBlank
    private String nombre;
    @NotNull
    private Categoria categoria;

    public Curso(DatosCurso datosCurso) {
        this.nombre= datosCurso.nombre();
        this.categoria=datosCurso.categoria();
    }
}
