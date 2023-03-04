package br.com.cwi.api.controller.response;

import br.com.cwi.api.domain.Visibilidade;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(NON_NULL)
public class PostagemResponse {
    private Long idPostagem;
    private Long idUsuario;
    private String conteudoPostagem;
    private LocalDateTime dataPostagem;
    private List<ComentarioResponse> comentarios;
    private Visibilidade visibilidade;
    private Long curtidas;
}
