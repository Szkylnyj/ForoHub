package Model.Respuesta;

import Model.Topico.Topico;
import Model.Usuario.Usuario;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record DatosRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Topico topico,
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull
        Usuario autor,
        @NotBlank
        String solucion
) {
}
