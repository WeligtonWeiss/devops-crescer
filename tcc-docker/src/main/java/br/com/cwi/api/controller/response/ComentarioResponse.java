package br.com.cwi.api.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(NON_NULL)
public class ComentarioResponse {
    private Long idComentario;
    private Long idPostagem;
    private Long idUsuario;
    private String conteudoComentario;
}
