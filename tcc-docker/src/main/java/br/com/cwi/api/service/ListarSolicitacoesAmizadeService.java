package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.mapper.AmizadeMapper;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarSolicitacoesAmizadeService {

    @Autowired
    AmizadeRepository amizadeRepository;

    @Autowired
    BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    public List<AmizadeResponse> listar() {
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        List<Amizade> amizadesSolicitadas = amizadeRepository.findBySituacaoAndAmigo(Situacao.SOLICITADA, usuario);

        return amizadesSolicitadas.stream()
                .map(AmizadeMapper::toResponse)
                .collect(Collectors.toList());
    }
}
