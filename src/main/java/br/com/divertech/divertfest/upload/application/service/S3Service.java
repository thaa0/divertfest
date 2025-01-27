package br.com.divertech.divertfest.upload.application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
public class S3Service {

    private final S3Client s3Client;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    // Método para gerar um nome aleatório de 16 caracteres
    private String generateRandomFileName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Método para obter a extensão do arquivo
    private String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        return (dotIndex == -1) ? "" : filename.substring(dotIndex);
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String bucketName = "divertfestbucket";

        // Gera o nome aleatório com a extensão do arquivo original
        String randomFileName = generateRandomFileName();
        String fileExtension = getFileExtension(file.getOriginalFilename());
        String key = "uploads/" + randomFileName + fileExtension;

        // Cria um arquivo temporário para o upload
        Path tempFile = Files.createTempFile(randomFileName, fileExtension);
        file.transferTo(tempFile.toFile());

        // Faz o upload para o S3
        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .build(),
                tempFile
        );

        // Remove o arquivo temporário
        Files.delete(tempFile);

        // Retorna a URL pública do arquivo
        return String.format("https://%s.s3.amazonaws.com/%s", bucketName, key);
    }
}
