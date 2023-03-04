package br.com.cwi.api.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @JsonInclude(NON_NULL)
public class DetalharUsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String apelido;
    private String imagemPerfil;
    private List<AmizadeResponse> amizades;
    private List<ComentarioResponse> comentarios;
    private List<PostagemResponse> postagens;
    private List<PostagemResponse> postagensCurtidas;
}
