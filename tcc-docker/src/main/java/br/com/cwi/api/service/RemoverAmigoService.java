package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.RemoverAmigoRequest;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import br.com.cwi.api.service.core.FiltrarAmigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RemoverAmigoService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private FiltrarAmigoService filtrarAmigoService;

    @Transactional
    public void remover(Long amigoId) {
        Usuario usuario = buscarUsuarioAutenticadoService.get();
        Usuario amigo = buscarUsuarioService.porId(amigoId);

        Optional<Amizade> amizadeSolicitadaOpt = filtrarAmigoService.filtrar(usuario, amigoId);
        Optional<Amizade> amizadeAceitaOpt = filtrarAmigoService.filtrar(amigo, usuario.getId());

        Amizade amizadeSolicitada = amizadeSolicitadaOpt.get();
        Amizade amizadeAceita = amizadeAceitaOpt.get();

        amizadeRepository.delete(amizadeSolicitada);
        amizadeRepository.delete(amizadeAceita);
    }
}
