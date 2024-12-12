package br.com.divertech.divertfest.locatario.application.api;

import br.com.divertech.divertfest.locador.application.api.LocadorDetalhadoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("v1/")
public interface LocatarioAPI {
    @PostMapping("public/locatario")
    @ResponseStatus(code = HttpStatus.CREATED)
    LocatarioCriadoResponse cadastraNovoLocatario(@RequestBody @Valid LocatarioNovoRequest locatarioNovo);

    @GetMapping("/admin/locatario/email/{email}")
    @ResponseStatus(code = HttpStatus.OK)
    LocatarioDetalhadoResponse getLocatario(@PathVariable String email);

    @GetMapping("/admin/locatario/{idLocatario}")
    @ResponseStatus(code = HttpStatus.OK)
    LocatarioDetalhadoResponse getLocatarioById(@PathVariable UUID idLocatario);

    @PatchMapping("/admin/locatario/{idLocatario}/suspende")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void suspendeLocatario(@PathVariable UUID idLocatario);

    @PatchMapping("/admin/locatario/{idLocatario}/ativa")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void ativaLocatario(@PathVariable UUID idLocatario);
}
