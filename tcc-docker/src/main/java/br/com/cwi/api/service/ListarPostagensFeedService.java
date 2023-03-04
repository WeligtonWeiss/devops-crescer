package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.PostagemResponse;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.domain.Visibilidade;
import br.com.cwi.api.mapper.PostagemMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarPostagensFeedService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private PostagemRepository postagemRepository;

    public Page<PostagemResponse> listar(Pageable pageable) {
        Usuario usuario = buscarUsuarioAutenticadoService.get();


        Page<Postagem> postagens = postagemRepository.findByFeed(usuario, Situacao.ACEITA , Visibilidade.PUBLICO, pageable);


        return postagens.map(PostagemMapper::toResponse);
    }
}
