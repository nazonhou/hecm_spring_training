package bj.hecm.demospringconcepts.controllers;

import bj.hecm.demospringconcepts.entities.User;
import bj.hecm.demospringconcepts.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(
                userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getOneUser(@PathVariable String username){
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }
}
