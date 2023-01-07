
package artists.gallery.bsd.project.services;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.repository.UserRepository;
import artists.gallery.bsd.project.vo.UserRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public List<UserRequestVo> getAllUsers(){

        List<User> listU = new ArrayList<>();
        List<UserRequestVo> listVo = new ArrayList<>();

        listU = userRepository.findAll();

        for(Integer i=0; i< listU.size(); i+=1) {
            User user = listU.get(i);
            UserRequestVo userRequestVo = UserRequestVo.builder()
                    .username(user.getUserName())
                    .email(user.getEmail())
                    .build();
            listVo.add(userRequestVo);
        }

        return listVo;
    }

    public void registerNewUser(UserRequestVo userRequestVo) {
        List<UserRequestVo> list = getAllUsers();
        User user = new User();
        if(list.contains(userRequestVo)) {
            user = User.builder()
                    .userName(userRequestVo.getUsername())
                    .password(userRequestVo.getPassword())
                    .email(userRequestVo.getEmail())
                    .build();

            userRepository.save(user);
        }else {
            user = null;
        }
    }

    public User login(UserRequestVo userRequestVo) {
        User user = userRepository.findUser(userRequestVo.getUsername(), userRequestVo.getPassword());
        if (user != null) {
            return user;
        }
        return null;
    }

        public Integer getNumberOfUsers(){
            List<UserRequestVo> list = getAllUsers();
            Integer numberOfUsers = list.size();
            return numberOfUsers;
        }

}
 