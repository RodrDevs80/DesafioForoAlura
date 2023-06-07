package com.API.alura.foro.simple.APIForoAlura.domain.topicos;

import com.API.alura.foro.simple.APIForoAlura.domain.respuestas.DatosRespuesta;
import com.API.alura.foro.simple.APIForoAlura.domain.respuestas.Respuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensajeTopico;
    private String autorTopico;
    private String cursoDelTopico;
    private LocalDateTime fechaDeCreacionTopico;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;
    private Boolean activo;
    @Embedded
    private Respuesta respuestas;

    public Topico(DatosRegistroTopico datosRegistro) {
        this.activo=true;
        this.fechaDeCreacionTopico=LocalDateTime.now();
        this.titulo= datosRegistro.titulo();
        this.mensajeTopico= datosRegistro.mensajeTopico();
        this.autorTopico= datosRegistro.autorTopico();
        this.cursoDelTopico= datosRegistro.cursoDelTopico();
        this.status=datosRegistro.status();
        this.respuestas=new Respuesta(datosRegistro.respuestas());
    }


    public void actulizarTopico(DatosActualizarTopicos topicoActualizar) {
        if (topicoActualizar.titulo()!=null){
            this.titulo= topicoActualizar.titulo();
        }
        if (topicoActualizar.mensajeTopico()!=null){
            this.mensajeTopico= topicoActualizar.mensajeTopico();
        }
        if (topicoActualizar.autorTopico()!=null){
            this.autorTopico= topicoActualizar.autorTopico();
        }
        if (topicoActualizar.cursoDelTopico()!=null){
            this.cursoDelTopico= topicoActualizar.cursoDelTopico();
        }
        if (topicoActualizar.status()!=null){
            this.status=topicoActualizar.status();
        }

    }

    public void desactivarTopico() {
        this.activo=false;
    }
}
