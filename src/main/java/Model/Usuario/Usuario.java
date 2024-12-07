package Model.Usuario;

import Model.Perfil.Perfil;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nombre;
    @Email
    @NotBlank
    private String correoElectronico;
    @NotBlank
    private String contrasena;
    @Embedded
    private Perfil perfiles;
}
