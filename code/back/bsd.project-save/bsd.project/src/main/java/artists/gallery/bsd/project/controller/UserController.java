package artists.gallery.bsd.project.controller;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.services.UserService;
import artists.gallery.bsd.project.vo.UserRequestVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @GetMapping("/user/{userId}")
    @CrossOrigin
    public UserRequestVo getUserById(@PathVariable Long userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping("/users")
    @CrossOrigin
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/register")
    @CrossOrigin
    public ResponseEntity<String> registerNewUser(@RequestBody UserRequestVo userRequestVo) {
        Boolean exist = userService.registerNewUser(userRequestVo);
        String userName = userRequestVo.getUsername();
        if (!exist) {
            return new ResponseEntity<>("New user " + userName + " has been registered", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User name "+userName+" already exists", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/user/login")
    @CrossOrigin
    public ResponseEntity<User> login(@RequestBody UserRequestVo userRequestVo) {
        User user = userService.login(userRequestVo);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/user/how-many")
    @CrossOrigin
    public Integer getNumberOfUsers(){
        return userService.getNumberOfUsers();
    }

    @DeleteMapping("/user/{userId}")
    @CrossOrigin
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }
}