package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.CriarPostagemRequest;
import br.com.cwi.api.controller.response.PostagemResponse;
import br.com.cwi.api.domain.Postagem;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PostagemMapper {
    public static PostagemResponse toResponse(Postagem postagem) {
        return PostagemResponse.builder()
                .idPostagem(postagem.getId())
                .idUsuario(postagem.getUsuario().getId())
                .conteudoPostagem(postagem.getConteudo())
                .dataPostagem(postagem.getDataPostagem())
                .comentarios(postagem.getComentarios().stream()
                        .map(ComentarioMapper::toResponse)
                        .collect(Collectors.toList()))
                .visibilidade(postagem.getVisibilidade())
                .curtidas((long) postagem.getUsuariosCurtiram().size())
                .build();
    }

    public static Postagem toEntity(CriarPostagemRequest request) {
        Postagem postagem = new Postagem();

        postagem.setVisibilidade(request.getVisibilidade());
        postagem.setConteudo(request.getConteudo());

        return postagem;
    }
}
