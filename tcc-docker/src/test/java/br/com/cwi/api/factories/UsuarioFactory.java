package br.com.cwi.api.factories;

import br.com.cwi.api.security.domain.Usuario;

import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario get() {
        Usuario usuario = new Usuario();

        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNomeCompleto("Usuário de teste");
        usuario.setEmail("teste@cwi.com.br");
        usuario.setDataNascimento(LocalDate.of(1990, 1, 1));

        return usuario;
    }

    public static Usuario getAmigoSolicitado(){
        Usuario usuario = new Usuario();

        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNomeCompleto("Usuário de teste");
        usuario.setEmail("teste@cwi.com.br");
        usuario.setDataNascimento(LocalDate.of(1990, 1, 1));
        usuario.getAmigos().add(AmizadeFactory.getSolicitada());
        return usuario;
    }

//    public static Usuario getAmigoAceito(){
//        Usuario usuario = new Usuario();
//
//        usuario.setId(SimpleFactory.getRandomLong());
//        usuario.setNomeCompleto("Usuário de teste");
//        usuario.setEmail("teste@cwi.com.br");
//        usuario.setDataNascimento(LocalDate.of(1990, 1, 1));
//        usuario.getAmigos().add(AmizadeFactory.getAceita());
//
//        return usuario;
//    }

}