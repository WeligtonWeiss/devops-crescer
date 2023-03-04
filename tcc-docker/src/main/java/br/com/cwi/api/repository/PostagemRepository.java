package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.domain.Visibilidade;
import br.com.cwi.api.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostagemRepository  extends JpaRepository<Postagem, Long> {

    @Query("SELECT po FROM Postagem po " +
            "JOIN po.usuario u " +
            "LEFT JOIN u.amigos ams " +
            "WHERE ((ams.amigo = :amigo AND ams.situacao = :situacao) OR po.visibilidade = :visibilidade OR po.usuario = :amigo)")
    Page<Postagem> findByFeed(@Param("amigo")Usuario amigo,@Param("situacao")Situacao situacao, @Param("visibilidade")Visibilidade visibilidade, Pageable pageable);

    @Query("SELECT po FROM Postagem po " +
            "JOIN po.usuario u " +
            "LEFT JOIN u.amigos am " +
            "WHERE (((am.amigo = :usuarioLogado AND am.situacao = :situacao) OR (po.visibilidade = :visibilidade)) AND (po.usuario = :usuarioPerfil))")
    Page<Postagem> findByPerfilUsuario(@Param("usuarioLogado")Usuario usuarioLogado, @Param("usuarioPerfil")Usuario usuarioPerfil, @Param("situacao")Situacao aceita, @Param("visibilidade")Visibilidade publico, Pageable pageable);
}
