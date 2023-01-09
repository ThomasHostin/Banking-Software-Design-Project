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
        String token = createToken(user);
        UserLogin userLogin = UserLogin.builder()
                .userId(user.getUserId())
                .token(token)
                .build();
        userLoginRepository.save(userLogin);


    }

    public void deleteByUserLoginId(Long userLoginId){
        userLoginRepository.deleteById(userLoginId);
    }

    public String createToken(User user){
        String token = user.getUserName() + Math.round(Math.random()*10*user.getUserId());
        return token;
    }

    public UserLogin findByToken(String token){
        UserLogin userLogin = userLoginRepository.findUserByToken(token);
        return userLogin;
    }
}
