package br.com.divertech.divertfest.upload.application.api;

import br.com.divertech.divertfest.upload.application.service.S3Service;
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
            // Validação adicional com token (se necessário)
            String fileUrl = s3Service.uploadFile(file);
            return fileUrl; // Retorna a URL do arquivo no S3
        } catch (IOException e) {
            throw new RuntimeException("Erro ao enviar arquivo: " + e.getMessage(), e);
        }
    }
}
