package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.ListarPostagensPerfilUsuarioRequest;
import br.com.cwi.api.controller.response.PostagemResponse;
import br.com.cwi.api.service.ListarPostagemPorId;
import br.com.cwi.api.service.ListarPostagensFeedService;
import br.com.cwi.api.service.ListarPostagensPerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/posts")
public class PostagemController {

    @Autowired
    private ListarPostagensFeedService listarPostagensFeedService;

    @Autowired
    private ListarPostagensPerfilUsuarioService listarPostagensPerfilUsuarioService;

    @Autowired
    private ListarPostagemPorId listarPostagemPorId;

    @GetMapping
    @ResponseStatus(OK)
    public Page<PostagemResponse> listarPostagensFeed(@PageableDefault(sort = "dataPostagem", direction = Sort.Direction.DESC) Pageable pageable){
        return listarPostagensFeedService.listar(pageable);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(OK)
    public Page<PostagemResponse> listarPostagens(@PathVariable Long id,
                                                  @PageableDefault(sort = "dataPostagem", direction = Sort.Direction.DESC) Pageable pageable){
        return listarPostagensPerfilUsuarioService.listar(id, pageable);
    }
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PostagemResponse listarPostagemPorId(@PathVariable Long id){
        return listarPostagemPorId.listar(id);
    }

}
