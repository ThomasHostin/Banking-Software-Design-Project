
package artists.gallery.bsd.project.services;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.repository.UserRepository;
import artists.gallery.bsd.project.vo.UserRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserRequestVo findByUserId(Long userId) {

        User user = userRepository.findByUserId(userId);

        return UserRequestVo.builder()
                .username(user.getUserName())
                .email(user.getEmail())
                .build();
    }
}
 