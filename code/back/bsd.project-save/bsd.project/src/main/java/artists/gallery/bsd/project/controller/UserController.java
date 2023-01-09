package artists.gallery.bsd.project.controller;

import artists.gallery.bsd.project.model.User;
import artists.gallery.bsd.project.model.UserLogin;
import artists.gallery.bsd.project.services.UserLoginService;
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

    @Autowired
    @Qualifier("userLoginService")
    private UserLoginService userLoginService;

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
        String userName = userRequestVo.getUsername();
        if (user!=null) {
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
            userLoginService.login(user);
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

    @GetMapping("/user/isConnected")
    @CrossOrigin
    public boolean isConnected(@RequestBody UserRequestVo userRequestVo){
        User user = userService.findUser(userRequestVo.getUsername(), userRequestVo.getPassword());
        UserLogin userLogin = userLoginService.findByUserId(user.getUserId());
        if (userLogin!=null){
            return true;
        } else{
            return false;
        }
    }

    @DeleteMapping("/user/logout")
    @CrossOrigin
    public void logoutByUserLoginId(@RequestParam("userId") Long userId) {
        userLoginService.deleteByUserLoginId(userLoginService.findByUserId(userId).getUserLoginId());
    }

    @GetMapping("/user/username")
    @CrossOrigin
    public User findByUserName(@RequestParam("username") String userName){
        return userService.findUserByUserName(userName);
    }

    @GetMapping("/user/userlogin")
    @CrossOrigin
    public UserLogin getUserLoginId(@RequestParam String userName){
        User user = userService.findUserByUserName(userName);
        UserLogin userLogin = userLoginService.findByUserId(user.getUserId());
        return userLogin;
    }

    @GetMapping("/user/token")
    @CrossOrigin
    public UserLogin findByToken(@RequestParam String token){
        return userLoginService.findByToken(token);
    }
}