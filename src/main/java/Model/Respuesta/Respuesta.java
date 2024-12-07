package Model.Respuesta;

import Model.Topico.Topico;
import Model.Usuario.Usuario;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String mensaje;
    @Embedded
    private Topico topico;
    @NotNull
    private LocalDateTime fechaCreacion;
    @Embedded
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
