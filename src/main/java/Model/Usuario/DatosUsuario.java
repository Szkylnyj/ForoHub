package Model.Usuario;

import Model.Perfil.Perfil;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank
        String nombre,
        @Email
        @NotBlank
        String correoElectronico,
        @NotBlank
        String contrasena,
        @Embedded
        Perfil perfiles
        ) {
}
