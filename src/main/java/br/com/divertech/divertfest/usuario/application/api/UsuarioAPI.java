package br.com.divertech.divertfest.usuario.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/public/v1")
public interface UsuarioAPI {
    @PostMapping("/locatario")
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioCriadoResponse cadastraNovoLocatario(@RequestBody @Valid UsuarioNovoRequest usuarioNovo);

    @PostMapping("/locador")
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioCriadoResponse cadastraNovoLocador(@RequestBody @Valid UsuarioNovoRequest usuarioNovo);

    @GetMapping("/admin/email/{email}")
    @ResponseStatus(code = HttpStatus.OK)
    UsuarioDetalhadoResponde getUsuario(@PathVariable String email);

    @GetMapping("/admin/id/{idUsuario}")
    @ResponseStatus(code = HttpStatus.OK)
    UsuarioDetalhadoResponde getUsuarioById(@PathVariable UUID idUsuario);

    @PatchMapping("/usuario/{idUsuario}/suspende")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void suspendeUsuario(@PathVariable UUID idUsuario);
}