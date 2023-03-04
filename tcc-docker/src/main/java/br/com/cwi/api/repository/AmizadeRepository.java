package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
    List<Amizade> findBySituacaoAndAmigo(Situacao solicitada, Usuario usuario);
}
