package artists.gallery.bsd.project.services;

import artists.gallery.bsd.project.model.Image;
import artists.gallery.bsd.project.repository.ImageRepository;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.TypedQuery;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image save(MultipartFile file, String imageName, String description, String imageUserName) throws IOException, OutOfMemoryError {
        Image image = new Image();
        image.setImageName(imageName);
        image.setImageDescription(description);
        image.setImageUserName(imageUserName);
        //image.setImageHashtags(imageHashtags);
        image.setImageType(file.getContentType());
        InputStream inputStream = file.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageData = byteArrayOutputStream.toByteArray();

        image.setImageData(imageData);
        return imageRepository.save(image);
    }

    public Image findImageById(Long imageId) {
        return imageRepository.findByImageId(imageId);
    }

    public List<Image> findLatestImageByUserName(String imageUserName, Long untilWhat, Long fromWhich){
        return imageRepository.findLatestImageByUserName(imageUserName, untilWhat, fromWhich);
    }

    public String findLatestImage(Long howMany){
        return imageRepository.findLatestImage(howMany);
    }

    public List<Image> findAllByUserName(String imageUserName){
        return imageRepository.findAllByUserName(imageUserName);
    }
}