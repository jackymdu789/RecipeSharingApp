package com.recipe.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {
	@Autowired
	ImageRepository repo;

    @Value("${file.upload-dir}")
    private static String uploadDir;

    public static String storeFile(MultipartFile file) throws IOException {
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        Path filePath = path.resolve(file.getOriginalFilename());
        file.transferTo(filePath.toFile());
        return filePath.toString();
    }

}
