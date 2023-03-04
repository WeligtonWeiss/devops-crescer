package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Situacao;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
public class AmizadeExisteValidator {


    public static final String AMIGO_NAO_EXISTE = "O usuário não tem nenhum amigo com esse id";
    public static final String NÃO_ACEITOU_A_SOLICITAÇÃO_DE_AMIZADE = "O amigo ainda não aceitou a solicitação de amizade";

    public void validar(Optional<Amizade> amigoOpt) {
        if(amigoOpt.isEmpty()){
            returnError(AMIGO_NAO_EXISTE);
        }
    }

    private void returnError(String mensagem) {
        throw new ResponseStatusException(UNPROCESSABLE_ENTITY,
                mensagem);
    }
}
