package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AceitarAmigoRequest;
import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarAmizadeService;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import br.com.cwi.api.service.core.FiltrarAmigoService;
import br.com.cwi.api.validator.SituacaoAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.cwi.api.domain.Situacao.SOLICITADA;
import static br.com.cwi.api.mapper.AmizadeMapper.toEntity;
import static br.com.cwi.api.mapper.AmizadeMapper.toResponse;

@Service
public class AceitarAmigoService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private BuscarAmizadeService buscarAmizadeService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private SituacaoAmizadeValidator situacaoAmizadeValidator;

    @Autowired
    private FiltrarAmigoService filtrarAmigoService;

    @Transactional
    public AmizadeResponse aceitar(AceitarAmigoRequest request) {
        Usuario usuario = buscarUsuarioService.porId(request.getUsuarioId());
        Usuario amigo = buscarUsuarioAutenticadoService.get();

        Optional<Amizade> amizadeSolicitadaOpt = filtrarAmigoService.filtrar(usuario, amigo.getId());

        situacaoAmizadeValidator.validar(amizadeSolicitadaOpt, SOLICITADA);

        Amizade amizadeSolicitada = amizadeSolicitadaOpt.get();
        Amizade amizadeAceita = toEntity(amigo, usuario);
        amizadeSolicitada.setSituacao(Situacao.ACEITA);
        amizadeAceita.setSituacao(Situacao.ACEITA);

        amizadeRepository.save(amizadeSolicitada);
        amizadeRepository.save(amizadeAceita);

        return toResponse(amizadeAceita);
    }
}
