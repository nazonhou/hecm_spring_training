package bj.hecm.demospringconcepts.services;

import bj.hecm.demospringconcepts.dto.GetAllUsersDto;
import bj.hecm.demospringconcepts.dto.UserDto;
import bj.hecm.demospringconcepts.dto.requests.CreateUserRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto createUser(CreateUserRequest request);

    List<UserDto> getAllUsers(GetAllUsersDto dto);
}
