package artists.gallery.bsd.project.services;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.model.UserLogin;
import artists.gallery.bsd.project.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    public UserLogin findByUserId(Long userId) {
        return userLoginRepository.findByUserId(userId);
    }

    public void login(User user){
        UserLogin userLogin = UserLogin.builder()
                .userId(user.getUserId())
                .build();
        userLoginRepository.save(userLogin);
    }

    public void deleteByUserLoginId(Long userLoginId){
        userLoginRepository.deleteById(userLoginId);
    }
}
