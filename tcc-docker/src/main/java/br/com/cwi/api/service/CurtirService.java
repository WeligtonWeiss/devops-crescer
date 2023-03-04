package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.CurtirRequest;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.service.core.BuscarPostagemService;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean curtir(CurtirRequest request) {
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        Postagem postagem = buscarPostagemService.porId(request.getPostagemId());

        if(usuario.getPostsCurtidos().contains(postagem)){
            usuario.removerCurtida(postagem);
            usuarioRepository.save(usuario);
            return true;
        }
        usuario.adicionarCurtida(postagem);
        usuarioRepository.save(usuario);
        return false;
    }
}
