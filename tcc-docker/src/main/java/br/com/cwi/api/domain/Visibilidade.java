package br.com.cwi.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Visibilidade {
    AMIGOS(Texto.AMIGOS), PUBLICO(Texto.PUBLICO);

    public static class Texto {
        public static final String AMIGOS = "Somente amigos";
        public static final String PUBLICO = "Público";
    }

    private final String role;
}
