package artists.gallery.bsd.project.repository;

import artists.gallery.bsd.project.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    public Image findByImageId(Long imageId);

    @Query("SELECT i FROM Image i WHERE i.imageName = ?1 and i.imageDescription = ?2")
    public Image findByImageNameAndImageDescription(String name, String description);

}
