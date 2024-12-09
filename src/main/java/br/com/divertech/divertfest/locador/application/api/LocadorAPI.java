package br.com.divertech.divertfest.locador.application.api;

import br.com.divertech.divertfest.usuario.application.api.UsuarioCriadoResponse;
import br.com.divertech.divertfest.usuario.application.api.UsuarioNovoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1")
public interface LocadorAPI {

    @PostMapping("/public/locador")
    @ResponseStatus(code = HttpStatus.CREATED)
    LocadorCriadoResponse cadastraNovoLocador(@RequestBody @Valid LocadorNovoRequest locadorNovo);

}