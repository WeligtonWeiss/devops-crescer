package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ComentarRequest {
    @NotNull
    private Long postagemId;

    @NotBlank
    private String conteudo;
}
