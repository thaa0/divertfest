package br.com.divertech.divertfest.brinquedo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/")
public interface BrinquedoAPI {

    @PostMapping("locador/brinquedos")
    @ResponseStatus(HttpStatus.CREATED)
    BrinquedoResponse cadastraBrinquedo(@RequestHeader(name = "Authorization", required = true) String token, @RequestBody BrinquedoRequest brinquedoRequest);

    @GetMapping("locador/brinquedos/{idBrinquedo}")
    @ResponseStatus(HttpStatus.OK)
    BrinquedoResponse buscaBrinquedoPorId(@PathVariable UUID idBrinquedo);

    //editar brinquedo cadastrado
    @PatchMapping("locador/brinquedos/{idBrinquedo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void editaBrinquedo(@RequestHeader(name = "Authorization", required = true) String token,
@PathVariable UUID idBrinquedo, @RequestBody BrinquedoEditaRequest brinquedoEditaRequest);

}