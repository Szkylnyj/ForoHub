package Model.Topico;

import Model.Curso.Curso;
import Model.Respuesta.Respuesta;
import Model.Usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;


public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @Embedded
    private Usuario autor;

    @Embedded
    private Curso curso;

    @Embedded
    private Respuesta respuesta;

    public Topico(DatosTopico datosTopico) {
        this.titulo= datosTopico.titulo();
        this.mensaje= datosTopico.mensaje();
        this.fechaCreacion=datosTopico.fechaCreacion();
        this.status= datosTopico.status();
        this.autor= datosTopico.autor();
        this.curso= datosTopico.curso();
        this.respuesta= datosTopico.respuesta();
    }
}
