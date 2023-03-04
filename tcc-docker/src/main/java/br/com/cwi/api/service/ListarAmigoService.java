package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.ListarAmigoRequest;
import br.com.cwi.api.controller.response.AmigoResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import br.com.cwi.api.service.core.FiltrarAmigoService;
import br.com.cwi.api.validator.AmizadeExisteValidator;
import br.com.cwi.api.validator.SituacaoAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.cwi.api.domain.Situacao.ACEITA;
import static br.com.cwi.api.mapper.AmigoMapper.toResponse;

@Service
public class ListarAmigoService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private AmizadeExisteValidator amizadeExisteValidator;

    @Autowired
    private SituacaoAmizadeValidator situacaoAmizadeValidator;

    @Autowired
    private FiltrarAmigoService filtrarAmigoService;

    public AmigoResponse listar(ListarAmigoRequest request) {
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        Optional<Amizade> amigoOpt = filtrarAmigoService.filtrar(usuario, request.getAmigoId());

        amizadeExisteValidator.validar(amigoOpt);
        situacaoAmizadeValidator.validar(amigoOpt, ACEITA);

        Usuario amigo =  amigoOpt.get().getAmigo();

        return toResponse(amigo);
    }
}
