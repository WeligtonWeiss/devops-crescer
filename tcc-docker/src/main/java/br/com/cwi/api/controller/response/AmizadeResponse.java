package br.com.cwi.api.controller.response;

import br.com.cwi.api.domain.Situacao;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(NON_NULL)
public class AmizadeResponse {
    private Long idAmizade;
    private Long idUsuario;
    private Long idAmigo;
    private Situacao situacao;
}
