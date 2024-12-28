package Model.Respuesta;

import Model.Topico.Topico;
import Model.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;


@Entity(name="Respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationDate;
    private String solution;
    @OneToOne
    @JoinColumn(name="author", referencedColumnName="id")
    private Usuario author;
    @OneToOne
    @JoinColumn(name="topico", referencedColumnName="id")
    private Topico topico;
    private boolean active;

    public Respuesta(Long id, String solution, Usuario usuario, Topico topico, LocalDateTime creationDate) {
        this.id=id;
        this.solution=solution;
        this.author=usuario;
        this.topico=topico;
        this.creationDate=LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public Usuario getAuthor() {
        return author;
    }

    public String getSolution() {
        return solution;
    }

    public Topico getTopico() {
        return topico;
    }

    public boolean isActive() {
        return active;
    }

    public void respuestaActualizada(RespuestaActualizadaDTO respuestaActualizadaDTO) {
        if (respuestaActualizadaDTO.solution() != null){
            this.solution=respuestaActualizadaDTO.solution();
        }
    }
    public void diactivateResponse(){

        this.active=false;
    }
}