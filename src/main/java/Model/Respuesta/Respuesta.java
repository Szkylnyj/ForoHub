package Model.Respuesta;

import Model.Topico.Topico;
import Model.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="respuestas")
@Entity(name= "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;
    @NotNull
    private LocalDateTime fechaCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuarios_id")
    private Usuario autor;
    @NotBlank
    private String solucion;

    public Respuesta(DatosRespuesta datosRespuesta) {
        this.mensaje= datosRespuesta.mensaje();
        this.topico=datosRespuesta.topico();
        this.fechaCreacion=datosRespuesta.fechaCreacion();
        this.autor= datosRespuesta.autor();
        this.solucion= datosRespuesta.solucion();
    }
}
