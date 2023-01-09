package artists.gallery.bsd.project.controller;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.services.UserService;
import artists.gallery.bsd.project.vo.UserRequestVo;

import artists.gallery.bsd.project.vo.UserTokenResponseVo;
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
    public ResponseEntity<User> registerNewUser(@RequestBody UserRequestVo userRequestVo) {
        User user = userService.registerNewUser(userRequestVo);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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

    @PostMapping("/user/authenticate")
    @CrossOrigin
    public ResponseEntity<User> authenticate(@RequestBody UserRequestVo userRequestVo) {
        User user = userService.validateUserCredentialsAndGenerateToken(userRequestVo);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}