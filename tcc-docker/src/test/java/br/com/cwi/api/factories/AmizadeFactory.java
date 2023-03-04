package br.com.cwi.api.factories;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Situacao;

public class AmizadeFactory {
    public static Amizade.AmizadeBuilder getBuilder(){
        return Amizade.builder()
                .id(SimpleFactory.getRandomLong())
                .amigo(UsuarioFactory.get())
                .usuario(UsuarioFactory.get());
    }

    public static Amizade getSolicitada(){
        return getBuilder()
                .situacao(Situacao.SOLICITADA)
                .build();
    }

    public static Amizade getAceita(){
        return getBuilder()
                .situacao(Situacao.ACEITA)
                .build();
    }
}
