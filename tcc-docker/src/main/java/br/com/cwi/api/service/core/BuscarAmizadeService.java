package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarAmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    public Amizade porId(Long amizadeId){
        return amizadeRepository.findById(amizadeId)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Amizade não encontrada"));
    }

}
