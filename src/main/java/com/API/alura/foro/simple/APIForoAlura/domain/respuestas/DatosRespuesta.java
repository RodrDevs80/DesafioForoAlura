package com.API.alura.foro.simple.APIForoAlura.domain.respuestas;

import com.API.alura.foro.simple.APIForoAlura.domain.topicos.DatosRegistroTopico;

import java.time.LocalDateTime;

public record DatosRespuesta(String respuestaMensaje,String autorMensajeRespuesta,Boolean solucion) {


}
