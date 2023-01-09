package artists.gallery.bsd.project.controller;

import artists.gallery.bsd.project.model.Image;
import artists.gallery.bsd.project.services.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/image/upload")
    public Image upload(@RequestParam("image") MultipartFile file, @RequestParam("image_name") String imageName, @RequestParam("description") String description) throws IOException {
        return imageService.save(file, imageName, description);
    }

    @Transactional
    @GetMapping("/image/{imageId}")
    public Image findImageById(@PathVariable Long imageId) {
        return imageService.findImageById(imageId);
    }
}