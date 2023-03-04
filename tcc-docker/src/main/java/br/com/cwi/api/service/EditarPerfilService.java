package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.EditarPerfilRequest;
import br.com.cwi.api.controller.response.EditarPerfilResponse;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.security.mapper.EditarPerfilMapper.toResponse;

@Service
public class EditarPerfilService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public EditarPerfilResponse editar(EditarPerfilRequest request){
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        usuario.setNomeCompleto(request.getNome());
        usuario.setApelido(request.getApelido());
        usuario.setImagemPerfil(request.getImagemPerfil());

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
