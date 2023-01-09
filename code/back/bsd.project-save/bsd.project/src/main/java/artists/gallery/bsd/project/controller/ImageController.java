package artists.gallery.bsd.project.controller;

import artists.gallery.bsd.project.model.Image;
import artists.gallery.bsd.project.services.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/image/upload")
    public Image upload(@RequestParam("image") MultipartFile file, @RequestParam("image_name") String imageName, @RequestParam("description") String description, @RequestParam("image-username") String imageUserName) throws IOException {
        return imageService.save(file, imageName, description, imageUserName);
    }

    @Transactional
    @GetMapping("/image/{imageId}")
    public Image findImageById(@PathVariable Long imageId) {
        return imageService.findImageById(imageId);
    }

    @Transactional
    @GetMapping("/image/latest/by-user")
    public List<Image> findLatestImageByUser(@RequestParam("imageUserName") String imageUserName, @RequestParam("untilWhat") Long untilWhat, @RequestParam("fromWhich") Long fromWhich){
        return imageService.findLatestImageByUserName(imageUserName, untilWhat, fromWhich);
    }

    @Transactional
    @GetMapping("image/latest")
    public List<Image> findLatestImage(@RequestParam("how-many") Long howMany){
        return imageService.findLatestImage(howMany);
    }

    @Transactional
    @GetMapping("image/by-user-name")
    public List<Image> findAllByUserName(@RequestParam("image-username") String imageUserName){
        return imageService.findAllByUserName(imageUserName);
    }
}