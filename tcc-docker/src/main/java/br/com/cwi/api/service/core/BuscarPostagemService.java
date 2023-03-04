package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarPostagemService {

    public static final String POSTAGEM_NÃO_EXISTE = "Essa postagem não existe";
    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem porId(Long postagemId){
        return postagemRepository.findById(postagemId)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, POSTAGEM_NÃO_EXISTE));
    }

}
