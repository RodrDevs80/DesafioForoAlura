package com.API.alura.foro.simple.APIForoAlura.controller;


import com.API.alura.foro.simple.APIForoAlura.domain.respuestas.DatosRespuesta;
import com.API.alura.foro.simple.APIForoAlura.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registoTopico
            (@RequestBody @Valid DatosRegistroTopico datosRegistro, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistro));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensajeTopico(), topico.getAutorTopico(), topico.getCursoDelTopico(), topico.getStatus().toString(),
                new DatosRespuesta(topico.getRespuestas().getRespuestaMensaje(),
                        topico.getRespuestas().getAutorMensajeRespuesta(), topico.getRespuestas().getSolucion()));

        URI url= uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
    @GetMapping
    @Transactional
    public ResponseEntity<Page<DatosListadoTopicos>> listarTopicos(@PageableDefault(size = 12) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopicos::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> buscarTopicoPorId(@PathVariable Long id){

        Topico topico = topicoRepository.getReferenceById(id);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensajeTopico(), topico.getAutorTopico(), topico.getCursoDelTopico(), topico.getStatus().toString(),
                new DatosRespuesta(topico.getRespuestas().getRespuestaMensaje(),
                        topico.getRespuestas().getAutorMensajeRespuesta(), topico.getRespuestas().getSolucion()));
        return ResponseEntity.ok(datosRespuestaTopico);
    }

    @DeleteMapping("eliminarDeBaseDeDatos/{id}")
    public void eliminarTopicosDeBaseDeDatos(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
    //Eliminacion Logica
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarLogicamenteTopicos(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopicos(@RequestBody @Valid DatosActualizarTopicos topicoActualizar ){
        Topico topico = topicoRepository.getReferenceById(topicoActualizar.id());
        topico.actulizarTopico(topicoActualizar);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensajeTopico(), topico.getAutorTopico(), topico.getCursoDelTopico(),topico.getStatus().toString(),
                new DatosRespuesta(topico.getRespuestas().getRespuestaMensaje(),
                        topico.getRespuestas().getAutorMensajeRespuesta(), topico.getRespuestas().getSolucion()));
        return ResponseEntity.ok(datosRespuestaTopico);
    }
}
