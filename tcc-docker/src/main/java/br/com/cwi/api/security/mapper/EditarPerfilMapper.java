package br.com.cwi.api.security.mapper;

import br.com.cwi.api.controller.response.EditarPerfilResponse;
import br.com.cwi.api.security.domain.Usuario;

public class EditarPerfilMapper {
    public static EditarPerfilResponse toResponse(Usuario usuario) {
        return EditarPerfilResponse.builder()
                .nome(usuario.getNomeCompleto())
                .apelido(usuario.getApelido())
                .imagemPerfil(usuario.getImagemPerfil())
                .build();
    }
}
