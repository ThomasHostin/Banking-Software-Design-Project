
package artists.gallery.bsd.project.services;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.repository.UserRepository;
import artists.gallery.bsd.project.vo.UserRequestVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<User> getAllUsers(){

        List<User> listU = new ArrayList<>();

        listU = userRepository.findAll();

        return listU;
    }

    public User registerNewUser(UserRequestVo userRequestVo) {
        List<User> list = getAllUsers();
        User user = new User();
        boolean exist = false;

        for(Integer i=0; i< list.size();i+=1){
            if(list.get(i).getUserName().equals(userRequestVo.getUsername())){
                exist = true;
            }
        }

        if(!exist) {
            user = User.builder()
                    .userName(userRequestVo.getUsername())
                    .password(userRequestVo.getPassword())
                    .email(userRequestVo.getEmail())
                    .build();
            userRepository.save(user);
        }
        return user;
    }

    public User login(UserRequestVo userRequestVo) {
        User user = userRepository.findUser(userRequestVo.getUsername(), userRequestVo.getPassword());
        if (user != null) {
            return user;
        }
        return null;
    }

    public Integer getNumberOfUsers(){
        List<User> list = getAllUsers();
        Integer numberOfUsers = list.size();
        return numberOfUsers;
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

    public User findUserByUserName(String userName){
        return userRepository.findUserByUserName(userName);
    }

    public User findUser(String userName, String password) {
        return userRepository.findUser(userName, password);
    }
}
 