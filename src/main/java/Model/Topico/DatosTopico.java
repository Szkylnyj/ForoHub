package Model.Topico;

import Model.Curso.Curso;
import Model.Respuesta.Respuesta;
import Model.Usuario.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;


public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @Future
        LocalDateTime fechaCreacion,
        @NotNull
        String status,
        @NotNull
        Usuario autor,
        @NotNull
        Curso curso,
        @NotNull
        List<Respuesta> respuestas
) {



}
