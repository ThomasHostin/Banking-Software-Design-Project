package artists.gallery.bsd.project.repository;

import artists.gallery.bsd.project.model.Image;

import artists.gallery.bsd.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    public Image findByImageId(Long imageId);

    @Query("SELECT i FROM Image i WHERE i.imageName = ?1 and i.imageDescription = ?2")
    public Image findByImageNameAndImageDescription(String name, String description);

    @Query(value="SELECT i.* FROM images_table i WHERE i.image_user_name = ?1 ORDER BY i.image_id DESC LIMIT = ?2, ?3", nativeQuery = true)
    public List<Image> findLatestImageByUserName(String imageUserName, Long untilWhat, Long fromWhich);

    @Query(value="SELECT i.image_data FROM images_table i ORDER BY i.image_id DESC LIMIT ?1", nativeQuery = true)
    public  String findLatestImage(Long howMany);

    @Query(value="SELECT i.* FROM images_tables i WHERE i.image_user_name = ?1", nativeQuery = true)
    public List<Image> findAllByUserName(String imageUserName);

}