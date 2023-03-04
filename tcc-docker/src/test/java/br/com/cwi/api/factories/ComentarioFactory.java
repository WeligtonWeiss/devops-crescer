package br.com.cwi.api.factories;

import br.com.cwi.api.domain.Comentario;

public class ComentarioFactory {

    public static Comentario get(){
        return Comentario.builder()
                .id(SimpleFactory.getRandomLong())
                .usuario(UsuarioFactory.get())
                .conteudo("conteudo de teste")
                .postagem(PostagemFactory.getPostPublico())
                .build();
    }
}
