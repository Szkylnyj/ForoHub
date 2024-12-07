package Model.Perfil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosPerfil(
        @NotBlank
        String nombre
) {
}
