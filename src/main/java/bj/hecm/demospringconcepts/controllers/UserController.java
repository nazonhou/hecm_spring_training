package bj.hecm.demospringconcepts.controllers;

import bj.hecm.demospringconcepts.dto.GetAllUsersDto;
import bj.hecm.demospringconcepts.dto.UserDto;
import bj.hecm.demospringconcepts.dto.requests.CreateUserRequest;
import bj.hecm.demospringconcepts.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(
            @Valid @RequestBody CreateUserRequest request
    ) {
        UserDto userDto = userService.createUser(request);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
            @RequestParam LocalDateTime start, @RequestParam LocalDateTime end
    ) {
        GetAllUsersDto dto = new GetAllUsersDto(start, end, page, size);
        return new ResponseEntity<>(
                userService.getAllUsers(dto),
                HttpStatus.OK
        );
    }
}
