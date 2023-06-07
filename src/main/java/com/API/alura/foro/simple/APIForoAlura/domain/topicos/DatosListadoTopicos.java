package com.API.alura.foro.simple.APIForoAlura.domain.topicos;

import com.API.alura.foro.simple.APIForoAlura.domain.respuestas.DatosRespuesta;

public record DatosListadoTopicos(Long id, String titulo,
                                  String mensajeTopico,
                                  String autorTopico,
                                  String cursoDelTopico,
                                  String status) {
    public DatosListadoTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensajeTopico(),
                topico.getAutorTopico(), topico.getCursoDelTopico(), topico.getStatus().toString());
    }
}
