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
public class EditarPerfilResponse {
    private String nome;

    private String apelido;

    private String imagemPerfil;
}
