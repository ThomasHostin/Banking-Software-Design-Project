package artists.gallery.bsd.project.services;

import artists.gallery.bsd.project.model.Image;
import artists.gallery.bsd.project.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image save(MultipartFile file, String imageName, String description, String imageUserName) throws IOException {
        Image image = new Image();
        image.setImageName(imageName);
        image.setImageDescription(description);
        image.setImageUserName(imageUserName);
        //image.setImageHashtags(imageHashtags);
        image.setImageType(file.getContentType());
        image.setImageData(file.getBytes());
        return imageRepository.save(image);
    }

    public Image findImageById(Long imageId) {
        return imageRepository.findByImageId(imageId);
    }

    public List<Image> findLatestImageByUserName(String imageUserName, Long untilWhat, Long fromWhich){
        return imageRepository.findLatestImageByUserName(imageUserName, untilWhat, fromWhich);
    }

    public List<Image> findLatestImage(Long howMany){
        return imageRepository.findLatestImage(howMany);
    }

    public List<Image> findAllByUserName(String imageUserName){
        return imageRepository.findAllByUserName(imageUserName);
    }
}