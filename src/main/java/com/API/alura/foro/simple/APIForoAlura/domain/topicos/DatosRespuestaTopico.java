package com.API.alura.foro.simple.APIForoAlura.domain.topicos;

import com.API.alura.foro.simple.APIForoAlura.domain.respuestas.DatosRespuesta;


public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensajeTopico,
                                   String autorTopico,
                                   String cursoDelTopico,
                                   String status,
                                   DatosRespuesta respuestas) {
}
