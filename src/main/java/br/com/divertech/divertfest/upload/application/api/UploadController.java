package br.com.divertech.divertfest.upload.application.api;

import br.com.divertech.divertfest.handler.APIException;
import br.com.divertech.divertfest.upload.application.service.S3Service;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadController implements UploadApi {

    private final S3Service s3Service;

    public UploadController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            return s3Service.uploadFile(file);
        } catch (IOException e) {
           throw APIException.build(HttpStatus.BAD_REQUEST, "Erro ao enviar arquivo");
        }
    }
}
