package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.ListarPostagensPerfilUsuarioRequest;
import br.com.cwi.api.controller.response.PostagemResponse;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.domain.Visibilidade;
import br.com.cwi.api.mapper.PostagemMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPostagensPerfilUsuarioService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private PostagemRepository postagemRepository;

    public Page<PostagemResponse> listar(Long id, Pageable pageable) {
        Usuario usuarioLogado = buscarUsuarioAutenticadoService.get();

        Usuario usuarioPerfil = buscarUsuarioService.porId(id);

        Page<Postagem> postagens = postagemRepository
                .findByPerfilUsuario(usuarioLogado,usuarioPerfil, Situacao.ACEITA, Visibilidade.PUBLICO, pageable);

        return postagens.map(PostagemMapper::toResponse);
    }
}
