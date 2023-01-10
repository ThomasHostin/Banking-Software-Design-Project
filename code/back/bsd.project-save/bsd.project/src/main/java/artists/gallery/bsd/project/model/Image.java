package artists.gallery.bsd.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "images_table")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", updatable = false, nullable = false)
    private Long imageId;

    @Column(columnDefinition = "image_name")
    private String imageName;

    @Column(columnDefinition = "image_description")
    private String imageDescription;

    @Column(columnDefinition = "image_type")
    private String imageType;

    @Column(columnDefinition = "image_size")
    private Long imageSize;

    @Column(columnDefinition = "image_user_name")
    private String imageUserName;
    @Lob
    @Column(columnDefinition = "image_data")
    private byte[] imageData;

    @Lob
    //@Column(columnDefinition = "hashtags")
    private List<String> imageHashtags;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Long getImageSize() {
        return imageSize;
    }

    public void setImageSize(Long imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageUserName() {
        return imageUserName;
    }

    public void setImageUserName(String imageUserName) {
        this.imageUserName = imageUserName;
    }

    public List<String> getImageHashtags() {
        return imageHashtags;
    }

    public void setImageHashtags(List<String> imageHashtags) {
        this.imageHashtags = imageHashtags;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
