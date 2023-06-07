package com.API.alura.foro.simple.APIForoAlura.domain.respuestas;

import com.API.alura.foro.simple.APIForoAlura.domain.topicos.DatosRegistroTopico;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    private String respuestaMensaje;
    private LocalDateTime fechaCreacionMensajeRespuesta;
    private String autorMensajeRespuesta;
    private Boolean solucion;


    public Respuesta(DatosRespuesta respuestas) {
        this.fechaCreacionMensajeRespuesta=LocalDateTime.now();
        this.respuestaMensaje= respuestas.respuestaMensaje();
        this.autorMensajeRespuesta=respuestas.autorMensajeRespuesta();
        this.solucion= respuestas.solucion();
    }
}
