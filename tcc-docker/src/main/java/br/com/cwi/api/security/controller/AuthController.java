package br.com.cwi.api.security.controller;

import br.com.cwi.api.security.controller.request.UsuarioRequest;
import br.com.cwi.api.security.controller.response.UsuarioResponse;
import br.com.cwi.api.security.service.IncluirUsuarioService;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @PostMapping("/login")
    public UsuarioResponse login() {
        return usuarioAutenticadoService.getResponse();
    }

    @PostMapping("/register")
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }
}
