package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.AmigoResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.security.domain.Usuario;

import java.util.stream.Collectors;

public class AmigoMapper {


    public static AmigoResponse toResponse(Usuario usuario) {
        return AmigoResponse.builder()
                .amigoId(usuario.getId())
                .amigoNome(usuario.getNomeCompleto())
                .amigoEmail(usuario.getEmail())
                .amigoDataNascimento(usuario.getDataNascimento())
                .amigoApelido(usuario.getApelido())
                .amigoImagemPerfil(usuario.getImagemPerfil())
                .amigoPostagens(usuario.getPostagens().stream()
                        .map(PostagemMapper::toResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
