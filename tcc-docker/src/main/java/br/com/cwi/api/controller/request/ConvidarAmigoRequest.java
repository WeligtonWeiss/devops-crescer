package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ConvidarAmigoRequest {
    @NotNull
    private Long amigoId;
}
