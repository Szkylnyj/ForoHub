package Model.Perfil;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Perfil {


    private long id;
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarios_id")
    private String nombre;

    public Perfil(DatosPerfil datosPerfil) {
        this.nombre= datosPerfil.nombre();
    }
}
