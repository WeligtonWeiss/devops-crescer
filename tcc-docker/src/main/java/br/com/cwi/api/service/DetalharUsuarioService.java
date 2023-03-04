package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.DetalharUsuarioResponse;
import br.com.cwi.api.mapper.DetalharUsuarioMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharUsuarioService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    public DetalharUsuarioResponse detalhar(){
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        return DetalharUsuarioMapper.toResponse(usuario);
    }


}
