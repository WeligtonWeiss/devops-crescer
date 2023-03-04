package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.CriarPostagemRequest;
import br.com.cwi.api.controller.response.PostagemResponse;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.mapper.PostagemMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import br.com.cwi.api.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.mapper.PostagemMapper.toEntity;

@Service
public class CriarPostagemService {

    @Autowired
    private NowService nowService;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Transactional
    public PostagemResponse criar(CriarPostagemRequest request) {
        Postagem postagem = toEntity(request);

        postagem.setDataPostagem(nowService.getDateTime());
        postagem.setUsuario(buscarUsuarioAutenticadoService.get());

        postagemRepository.save(postagem);

        return PostagemMapper.toResponse(postagem);
    }
}
