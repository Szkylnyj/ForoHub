package Model.Curso;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nombre;
    @NotNull
    private Categoria categoria;

    public Curso(DatosCurso datosCurso) {
        this.nombre= datosCurso.nombre();
        this.categoria=datosCurso.categoria();
    }
}
