package br.com.cwi.api.service.core;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario porId(Long usuarioId){
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuário não encontrado"));
    }
}
