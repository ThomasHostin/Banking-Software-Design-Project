package artists.gallery.bsd.project.services;

import artists.gallery.bsd.project.model.Image;
import artists.gallery.bsd.project.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image save(MultipartFile file, String imageName, String description) throws IOException {
        Image image = new Image();
        image.setImageName(imageName);
        image.setImageDescription(description);
        //image.setImageHashtags(imageHashtags);
        image.setImageType(file.getContentType());
        image.setImageData(file.getBytes());
        return imageRepository.save(image);
    }

    public Image findImageById(Long imageId) {
        return imageRepository.findByImageId(imageId);
    }
}