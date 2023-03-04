package br.com.cwi.api.factories;

import br.com.cwi.api.domain.Postagem;

import static br.com.cwi.api.domain.Visibilidade.AMIGOS;
import static br.com.cwi.api.domain.Visibilidade.PUBLICO;

public class PostagemFactory {
    public static Postagem.PostagemBuilder getBuilder(){
        return Postagem.builder()
                .id(SimpleFactory.getRandomLong())
                .usuario(UsuarioFactory.get())
                .conteudo("conteudo de teste");
    }

    public static Postagem getPostPublico(){
        return getBuilder()
                .visibilidade(PUBLICO)
                .build();
    }

    public static Postagem getPostAmigos(){
        return getBuilder()
                .visibilidade(AMIGOS)
                .build();
    }
}
