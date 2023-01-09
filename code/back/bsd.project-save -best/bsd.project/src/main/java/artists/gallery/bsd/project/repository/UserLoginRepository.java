package artists.gallery.bsd.project.repository;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{

    public UserLogin findByUserId(Long userId);
    
    public UserLogin findByUserLoginId(Long userLoginId);
}
