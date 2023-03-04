package br.com.cwi.api.security.repository;

import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("select u from Usuario u where (LOWER(u.email) like %:search% OR LOWER(u.nomeCompleto) like %:search%)")
    Page<Usuario> findByNome(String search, Pageable pageable);

    @Query("Select u from Usuario u join u.amigos am where ((am.situacao = :situacao) AND (LOWER(u.email) like %:search% OR LOWER(u.nomeCompleto) like %:search%))")
    Page<Usuario> findByAmigoNome(@Param("search")String search, @Param("situacao")Situacao aceita, Pageable pageable);
}
