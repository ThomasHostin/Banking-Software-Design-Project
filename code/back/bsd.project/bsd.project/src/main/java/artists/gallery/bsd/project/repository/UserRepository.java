package artists.gallery.bsd.project.repository;

import artists.gallery.bsd.project.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserId(Long userId);

    @Query("SELECT u FROM User u WHERE u.userName = ?1 and u.password = ?2")
    public User findUser(String userName, String password);

    //public User findByUserName(String userName);

}
