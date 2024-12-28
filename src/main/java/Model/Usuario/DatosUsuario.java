package Model.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        Long id,
        @NotBlank
        String nombre,
        @Email
        @NotBlank
        String correoElectronico,
        @NotBlank
        String contrasena,
        @NotBlank
        String username
        ) {

        public void DatosUsuarios(Long id, String nombre) {
        }

        public Long getId() {
                return id;
        }

        public String getNombre() {
                return nombre;
        }

        public String getCorreoElectronico() {
                return correoElectronico;
        }

        public @NotBlank String username() { return username;
        }
}
