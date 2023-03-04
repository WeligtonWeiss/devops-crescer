package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.PostagemResponse;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.mapper.PostagemMapper;
import br.com.cwi.api.service.core.BuscarPostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.mapper.PostagemMapper.toResponse;

@Service
public class ListarPostagemPorId {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    public PostagemResponse listar(Long id){
        Postagem postagem = buscarPostagemService.porId(id);

        return toResponse(postagem);
    }
}
