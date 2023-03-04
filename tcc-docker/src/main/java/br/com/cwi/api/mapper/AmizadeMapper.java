package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.security.domain.Usuario;

public class AmizadeMapper {
    public static Amizade toEntity(Usuario usuario, Usuario amigo){
        Amizade amizade = new Amizade();

        amizade.setUsuario(usuario);
        amizade.setAmigo(amigo);

        return amizade;
    }

    public static AmizadeResponse toResponse(Amizade amizade) {
        return AmizadeResponse.builder()
                .idAmizade(amizade.getId())
                .idUsuario(amizade.getUsuario().getId())
                .idAmigo(amizade.getAmigo().getId())
                .situacao(amizade.getSituacao())
                .build();
    }
}
