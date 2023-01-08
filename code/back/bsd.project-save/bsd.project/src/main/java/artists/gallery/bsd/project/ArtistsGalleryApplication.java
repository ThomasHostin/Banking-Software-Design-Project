package artists.gallery.bsd.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ArtistsGalleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtistsGalleryApplication.class, args);
	}

}
