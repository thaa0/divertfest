package br.com.divertech.divertfest.locador.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "v1/")
public interface LocadorAPI {

    @PostMapping("public/locador")
    @ResponseStatus(code = HttpStatus.CREATED)
    LocadorCriadoResponse cadastraNovoLocador(@RequestBody @Valid LocadorNovoRequest locadorNovo);

    @GetMapping("/admin/locador/email/{email}")
    @ResponseStatus(code = HttpStatus.OK)
    LocadorDetalhadoResponse getLocador(@PathVariable String email);

    @GetMapping("/admin/locador/id/{idLocador}")
    @ResponseStatus(code = HttpStatus.OK)
    LocadorDetalhadoResponse getLocadorById(@PathVariable UUID idLocador);

    @PatchMapping("/admin/locador/{idLocador}/ativo")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void ativaLocador(@PathVariable UUID idLocador);

    @PatchMapping("/admin/locador/{idLocador}/suspende")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void suspendeLocador(@PathVariable UUID idLocador);
}