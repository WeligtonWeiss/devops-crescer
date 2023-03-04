package br.com.cwi.api.domain;

import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Amizade {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "amigo_id")
    private Usuario amigo;

    @Enumerated(STRING)
    private Situacao situacao;
}
