package com.recipe.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.recipe.recipes.RecipeService;

import java.io.IOException;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class ImageController {

    @Autowired
    private RecipeService recipeService;


    @PostMapping("/images/{recipeId}")
    public void uploadImage(@PathVariable Integer recipeId, @RequestParam("file") MultipartFile file) throws IOException {
        String filePath = ImageService.storeFile(file);
        recipeService.addImageToRecipe(recipeId, file.getOriginalFilename(), filePath);
    }
}

