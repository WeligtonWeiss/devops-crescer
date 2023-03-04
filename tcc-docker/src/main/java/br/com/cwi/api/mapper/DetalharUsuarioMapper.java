package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.DetalharUsuarioResponse;
import br.com.cwi.api.security.domain.Usuario;

import java.util.stream.Collectors;

public class DetalharUsuarioMapper {
    public static DetalharUsuarioResponse toResponse(Usuario usuario) {
        return DetalharUsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .dataNascimento(usuario.getDataNascimento())
                .apelido(usuario.getApelido())
                .imagemPerfil(usuario.getImagemPerfil())
                .amizades((usuario.getAmigos().stream()
                        .map(AmizadeMapper::toResponse)
                        .collect(Collectors.toList())))
                .comentarios((usuario.getComentarios().stream()
                        .map(ComentarioMapper::toResponse)
                        .collect(Collectors.toList())))
                .postagens((usuario.getPostagens().stream()
                        .map(PostagemMapper::toResponse)
                        .collect(Collectors.toList())))
                .postagensCurtidas((usuario.getPostsCurtidos().stream()
                        .map(PostagemMapper::toResponse)
                        .collect(Collectors.toList())))
                .build();
    }
}
