package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.AmigoResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Situacao;
import br.com.cwi.api.mapper.AmigoMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.service.core.BuscarUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.cwi.api.domain.Situacao.ACEITA;

@Service
public class ListarAmigosService {

    @Autowired
    private BuscarUsuarioAutenticadoService buscarUsuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<AmigoResponse> listar(String search, Pageable pageable) {
        Usuario usuario = buscarUsuarioAutenticadoService.get();

        Page<Usuario> listaDeAmigosConfirmados = usuarioRepository.findByAmigoNome(search.toLowerCase(), ACEITA ,pageable);

        return listaDeAmigosConfirmados
                .map(AmigoMapper::toResponse);
    }
}
