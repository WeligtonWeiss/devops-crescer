package br.com.cwi.api.domain;

import br.com.cwi.api.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Comentario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;

    private String conteudo;
}
