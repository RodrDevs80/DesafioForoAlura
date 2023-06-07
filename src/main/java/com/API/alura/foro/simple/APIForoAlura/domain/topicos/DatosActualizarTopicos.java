package com.API.alura.foro.simple.APIForoAlura.domain.topicos;

import com.API.alura.foro.simple.APIForoAlura.domain.respuestas.DatosRespuesta;

public record DatosActualizarTopicos(Long id,
                                     String titulo,
                                     String mensajeTopico,
                                     String autorTopico,
                                     String cursoDelTopico,
                                     StatusTopico status) {
}
