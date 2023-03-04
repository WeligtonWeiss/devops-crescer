package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.ComentarRequest;
import br.com.cwi.api.controller.response.ComentarioResponse;
import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.mapper.ComentarioMapper;
import br.com.cwi.api.repository.ComentarioRepository;
import br.com.cwi.api.service.core.BuscarPostagemService;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public ComentarioResponse comentar(ComentarRequest request) {

        Comentario comentario = ComentarioMapper.toEntity(request);
        Postagem postagem = buscarPostagemService.porId(request.getPostagemId());

        comentario.setPostagem(postagem);
        comentario.setUsuario(buscarUsuarioAutenticadoService.get());

        comentarioRepository.save(comentario);

        return ComentarioMapper.toResponse(comentario);
    }
}
