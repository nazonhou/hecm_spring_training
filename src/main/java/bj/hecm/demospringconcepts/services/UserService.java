package bj.hecm.demospringconcepts.services;
import bj.hecm.demospringconcepts.dto.UserDto;
import bj.hecm.demospringconcepts.dto.requests.CreateUserRequest;

public interface UserService {
    UserDto createUser(CreateUserRequest request);
}
