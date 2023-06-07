package com.API.alura.foro.simple.APIForoAlura.domain.topicos;

import com.API.alura.foro.simple.APIForoAlura.domain.respuestas.DatosRespuesta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(

                                  @NotBlank
                                  String titulo,
                                  @NotBlank
                                  String mensajeTopico,
                                  @NotBlank
                                  String autorTopico,
                                  @NotBlank
                                  String cursoDelTopico,
                                  @NotNull
                                  StatusTopico status,
                                  @Valid
                                  DatosRespuesta respuestas) {
}
