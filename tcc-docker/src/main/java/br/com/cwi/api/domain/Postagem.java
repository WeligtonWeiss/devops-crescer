package br.com.cwi.api.domain;

import br.com.cwi.api.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Postagem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String conteudo;

    @Enumerated(STRING)
    private Visibilidade visibilidade;

    private LocalDateTime dataPostagem;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany(mappedBy = "postsCurtidos")
    private List<Usuario> usuariosCurtiram = new ArrayList<>();
}
