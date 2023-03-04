package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.validator.AmizadeExisteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FiltrarAmigoService {

    @Autowired
    private AmizadeExisteValidator amizadeExisteValidator;

    public Optional<Amizade> filtrar(Usuario usuario, Long amigoId){

        Optional<Amizade> amizadeSolicitadaOpt = usuario.getAmigos().stream()
                .filter(amizade -> amizade.getAmigo().getId() == amigoId)
                .findFirst();

        amizadeExisteValidator.validar(amizadeSolicitadaOpt);

        return amizadeSolicitadaOpt;
    }

}
