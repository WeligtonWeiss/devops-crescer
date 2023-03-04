package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Situacao;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static br.com.cwi.api.domain.Situacao.ACEITA;
import static br.com.cwi.api.domain.Situacao.SOLICITADA;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
public class SituacaoAmizadeValidator {

    public static final String NÃO_ACEITOU_A_SOLICITAÇÃO_DE_AMIZADE = "O amigo ainda não aceitou a solicitação de amizade";
    public static final String NENHUMA_SOLICITAÇÃO_DE_AMIZADE = "Não há nenhuma solicitação de amizade";

    public void validar(Optional<Amizade> amigoOpt, Situacao situacaoEsperada) {
        if(amigoOpt.get().getSituacao() != situacaoEsperada){
            if(situacaoEsperada == ACEITA){
                returnError(NÃO_ACEITOU_A_SOLICITAÇÃO_DE_AMIZADE);
            }
            if(situacaoEsperada == SOLICITADA){
                returnError(NENHUMA_SOLICITAÇÃO_DE_AMIZADE);
            }
        }
    }

    private void returnError(String mensagem) {
        throw new ResponseStatusException(UNPROCESSABLE_ENTITY,
                mensagem);
    }
}
