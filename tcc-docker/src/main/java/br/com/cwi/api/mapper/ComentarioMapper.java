package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.ComentarRequest;
import br.com.cwi.api.controller.response.ComentarioResponse;
import br.com.cwi.api.domain.Comentario;

public class ComentarioMapper {
    public static ComentarioResponse toResponse(Comentario comentario) {
        return ComentarioResponse.builder()
                .idComentario(comentario.getId())
                .idPostagem(comentario.getPostagem().getId())
                .idUsuario(comentario.getUsuario().getId())
                .conteudoComentario(comentario.getConteudo())
                .build();
    }

    public static Comentario toEntity(ComentarRequest request) {
        Comentario comentario = new Comentario();

        comentario.setConteudo(request.getConteudo());

        return comentario;
    }
}
