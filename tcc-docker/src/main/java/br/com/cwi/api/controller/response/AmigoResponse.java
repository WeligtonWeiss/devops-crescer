package br.com.cwi.api.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(NON_NULL)
public class AmigoResponse {
    private Long amigoId;
    private String amigoNome;
    private String amigoEmail;
    private LocalDate amigoDataNascimento;
    private String amigoApelido;
    private String amigoImagemPerfil;
    private List<PostagemResponse> amigoPostagens;
}
