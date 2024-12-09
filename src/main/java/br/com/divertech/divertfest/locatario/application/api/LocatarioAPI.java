package br.com.divertech.divertfest.locatario.application.api;

import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/")
public interface LocatarioAPI {
    @PostMapping("public/locatario")
    @ResponseStatus(code = HttpStatus.CREATED)
    LocatarioCriadoResponse cadastraNovoLocatario(@RequestBody @Valid LocatarioNovoRequest locatarioNovo);

}
