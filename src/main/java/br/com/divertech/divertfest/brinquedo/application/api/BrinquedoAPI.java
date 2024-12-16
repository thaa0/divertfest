package br.com.divertech.divertfest.brinquedo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PatchMapping("locador/brinquedos/{idBrinquedo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void editaBrinquedo(@RequestHeader(name = "Authorization", required = true) String token,
@PathVariable UUID idBrinquedo, @RequestBody BrinquedoEditaRequest brinquedoEditaRequest);

    @DeleteMapping("locador/brinquedos/{idBrinquedo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void apagaBrinquedo(@RequestHeader(name = "Authorization", required = true) String token, @PathVariable UUID idBrinquedo);

    @GetMapping("brinquedos")
    @ResponseStatus(HttpStatus.OK)
    List<BrinquedoResponse> listaBrinquedos();

    //Buscar brinquedos pelo nome
    @GetMapping("brinquedos/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    List<BrinquedoResponse> buscaBrinquedoPorNome(@PathVariable String nome);

    @GetMapping("locador/{idLocador}/brinquedos")
    @ResponseStatus(HttpStatus.OK)
    List<BrinquedoResponse> buscaBrinquedoPorLocador(@RequestHeader(name = "Authorization",
            required = true) String token, @PathVariable UUID idLocador);
}