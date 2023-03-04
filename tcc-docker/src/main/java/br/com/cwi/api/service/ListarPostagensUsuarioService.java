package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.PostagemResponse;
import br.com.cwi.api.mapper.PostagemMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPostagensUsuarioService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    public List<PostagemResponse> listar() {
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        return usuario.getPostagens().stream().map(PostagemMapper::toResponse).collect(Collectors.toList());
    }
}
