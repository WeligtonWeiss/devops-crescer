package br.com.cwi.api.service.core;

import br.com.cwi.api.security.config.UsuarioSecurity;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarUsuarioAutenticadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long getId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioSecurity usuarioSecurity = (UsuarioSecurity) authentication.getPrincipal();
        return usuarioSecurity.getId();
    }

    public Usuario get(){
        return usuarioRepository.findById(getId())
                .orElseThrow(()-> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuário não existe ou não está autenticado"));
    }
}
