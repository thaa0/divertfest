package br.com.divertech.divertfest.upload.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("v1/")
public interface UploadApi {

    @PostMapping("public/upload/")
    @ResponseStatus(HttpStatus.CREATED)
    String uploadFile(@RequestParam("file") MultipartFile file);
}
