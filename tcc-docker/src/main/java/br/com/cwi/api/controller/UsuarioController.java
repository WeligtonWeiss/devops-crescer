package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.*;
import br.com.cwi.api.controller.response.*;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private DetalharUsuarioService detalharUsuarioService;

    @Autowired
    private BuscarUsuarioPorNomeService buscarUsuarioPorNomeService;

    @Autowired
    private DetalharUsuarioByIdService detalharUsuarioByIdService;

    @Autowired
    private EditarPerfilService editarPerfilService;

    @Autowired
    private ListarAmigosService listarAmigosService;

    @Autowired
    private ListarAmigoService listarAmigoService;

    @Autowired
    private ConvidarAmigoService convidarAmigoService;

    @Autowired
    private AceitarAmigoService aceitarAmigoService;

    @Autowired
    private RemoverAmigoService removerAmigoService;

    @Autowired
    private ListarSolicitacoesAmizadeService listarSolicitacoesAmizadeService;

    @Autowired
    private ListarPostagensUsuarioService listarPostagensUsuarioService;

    @Autowired
    private CriarPostagemService criarPostagemService;

    @Autowired
    private ComentarService comentarService;
    @Autowired
    private CurtirService curtirService;

    @GetMapping
    @ResponseStatus(OK)
    public Page<DetalharUsuarioResponse> todosUsuariosSearch(@RequestParam(name = "search", required = false, defaultValue = "")String search, Pageable pageable){
        return buscarUsuarioPorNomeService.buscar(search, pageable);
    }

    @GetMapping("/me")
    @ResponseStatus(OK)
    public DetalharUsuarioResponse detalhar() {
        return  detalharUsuarioService.detalhar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public DetalharUsuarioResponse detalharById(@PathVariable Long id){
        return detalharUsuarioByIdService.detalhar(id);
    }

    @PutMapping("/me")
    @ResponseStatus(ACCEPTED)
    public EditarPerfilResponse editar(@Valid @RequestBody EditarPerfilRequest request){
        return editarPerfilService.editar(request);
    }

    @GetMapping("/me/friends")
    @ResponseStatus(OK)
    public Page<AmigoResponse> listarAmigos(@RequestParam(name = "search", required = false, defaultValue = "")String search, Pageable pageable){
        return listarAmigosService.listar(search, pageable);
    }

    @GetMapping("/me/friend")
    @ResponseStatus(OK)
    public AmigoResponse listarAmigoPorId(@RequestBody ListarAmigoRequest request){
        return listarAmigoService.listar(request);
    }

    @PostMapping("/me/friends/invite")
    @ResponseStatus(ACCEPTED)
    public AmizadeResponse convidarAmigo(@Valid @RequestBody ConvidarAmigoRequest request){
        return convidarAmigoService.solicitar(request);
    }

    @PutMapping("/me/friends/accept")
    @ResponseStatus(ACCEPTED)
    public AmizadeResponse aceitarAmigo(@Valid @RequestBody AceitarAmigoRequest request){
        return aceitarAmigoService.aceitar(request);
    }

    @DeleteMapping("/me/friends/remove/{id}")
    @ResponseStatus(NO_CONTENT)
    public void removerAmigo(@PathVariable Long id){
        removerAmigoService.remover(id);
    }

    @GetMapping("/me/friends/requests")
    @ResponseStatus(OK)
    public List<AmizadeResponse> listarSolicitacoesAmizade(){
        return listarSolicitacoesAmizadeService.listar();
    }

    @GetMapping("/me/posts")
    @ResponseStatus(OK)
    public List<PostagemResponse> listarPostagensUsuario(){
        return listarPostagensUsuarioService.listar();
    }

    @PostMapping("/me/post")
    @ResponseStatus(CREATED)
    public PostagemResponse criarPostagem(@Valid @RequestBody CriarPostagemRequest request) {
        return criarPostagemService.criar(request);
    }

    @PutMapping("/me/comment")
    @ResponseStatus(CREATED)
    public ComentarioResponse comentar(@Valid @RequestBody ComentarRequest request){
        return comentarService.comentar(request);
    }

    @PutMapping("/me/like")
    @ResponseStatus(OK)
    public boolean curtir(@Valid @RequestBody CurtirRequest request){
        return curtirService.curtir(request);
    }


}

