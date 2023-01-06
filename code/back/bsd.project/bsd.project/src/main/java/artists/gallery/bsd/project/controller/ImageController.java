package artists.gallery.bsd.project.controller;

import artists.gallery.bsd.project.model.Image;
import artists.gallery.bsd.project.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public Image upload(@RequestParam("image") MultipartFile file,@RequestParam("image_name") String name,@RequestParam("desciption") String description,@RequestParam("username") String userName) throws IOException {
        return imageService.save(file, name, description, userName);
    }
}
