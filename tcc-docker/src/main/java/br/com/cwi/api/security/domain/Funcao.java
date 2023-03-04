package br.com.cwi.api.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Funcao {

    USUARIO(Nomes.USUARIO);

    public static class Nomes {
        public static final String USUARIO = "ROLE_USUARIO";
    }

    private final String role;
    }
