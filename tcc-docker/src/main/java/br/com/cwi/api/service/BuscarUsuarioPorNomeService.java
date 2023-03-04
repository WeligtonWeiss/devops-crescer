package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.DetalharUsuarioResponse;
import br.com.cwi.api.mapper.DetalharUsuarioMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPorNomeService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<DetalharUsuarioResponse> buscar(String search, Pageable pageable) {
        Page<Usuario> usuariosFiltrados = usuarioRepository.findByNome(search.toLowerCase(), pageable);

        return usuariosFiltrados
                .map(DetalharUsuarioMapper::toResponse);
    }
}
