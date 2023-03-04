package br.com.cwi.api.security.domain;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.domain.Postagem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean ativo;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private String apelido;

    private String imagemPerfil;

    @OneToMany(mappedBy = "usuario")
    private List<Amizade> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "curtida",
    joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "postagem_id")
    )
    private List<Postagem> postsCurtidos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void adicionarCurtida(Postagem postagem){
        this.getPostsCurtidos().add(postagem);
        postagem.getUsuariosCurtiram().add(this);
    }

    public void removerCurtida(Postagem postagem) {
        this.getPostsCurtidos().remove(postagem);
        postagem.getUsuariosCurtiram().remove(this);
    }
}
