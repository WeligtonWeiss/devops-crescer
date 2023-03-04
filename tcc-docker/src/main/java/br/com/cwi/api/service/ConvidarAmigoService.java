package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.ConvidarAmigoRequest;
import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static br.com.cwi.api.domain.Situacao.SOLICITADA;
import static br.com.cwi.api.mapper.AmizadeMapper.*;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class ConvidarAmigoService {

    public static final String SOLICITAÇÃO_DE_AMIZADE_PARA_SI_MESMO = "Você não pode enviar solicitação de amizade para si mesmo";
    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Transactional
    public AmizadeResponse solicitar(ConvidarAmigoRequest request) {
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        if(request.getAmigoId() == usuario.getId()){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY,
                    SOLICITAÇÃO_DE_AMIZADE_PARA_SI_MESMO);
        }

        Usuario amigo = buscarUsuarioService.porId(request.getAmigoId());

        Amizade amizade = toEntity(usuario, amigo);
        amizade.setSituacao(SOLICITADA);

        amizadeRepository.save(amizade);

        return toResponse(amizade);
    }
}
