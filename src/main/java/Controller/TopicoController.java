package Controller;


import Model.Topico.DatosTopico;
import Model.Topico.Topico;
import Model.Topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder) {

        // Verifica si el tópico ya existe para evitar duplicados
        if (topicoRepository.findByTituloAndMensaje(datosTopico.titulo(), datosTopico.mensaje()).isPresent()) {
            return ResponseEntity.badRequest().body("Tópico duplicado no permitido");
        }

        // Guarda el tópico en la base de datos
        Topico topico = topicoRepository.save(new Topico(datosTopico));

        // Construye la URI del nuevo recurso creado

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        // Retorna la respuesta con el estado 201 Created
        return ResponseEntity.created(uri).body(topico);

    }
}
