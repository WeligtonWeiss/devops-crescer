package br.com.cwi.api.controller.request;

import br.com.cwi.api.domain.Visibilidade;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CriarPostagemRequest {
    @NotBlank
    private String conteudo;

    @NotNull
    private Visibilidade visibilidade;
}
