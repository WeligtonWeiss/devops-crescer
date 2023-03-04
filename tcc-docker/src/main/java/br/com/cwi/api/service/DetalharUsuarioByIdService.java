package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.DetalharUsuarioResponse;
import br.com.cwi.api.mapper.DetalharUsuarioMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharUsuarioByIdService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;
    public DetalharUsuarioResponse detalhar(Long usuarioId) {
        Usuario usuario = buscarUsuarioService.porId(usuarioId);

        return DetalharUsuarioMapper.toResponse(usuario);
    }
}
