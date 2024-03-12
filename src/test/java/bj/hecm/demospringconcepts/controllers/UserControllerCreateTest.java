package bj.hecm.demospringconcepts.controllers;

import bj.hecm.demospringconcepts.dto.UserDto;
import bj.hecm.demospringconcepts.dto.requests.CreateUserRequest;
import bj.hecm.demospringconcepts.repositories.UserRepository;
import bj.hecm.demospringconcepts.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerCreateTest {
    @MockBean
    UserRepository userRepository;
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getBadRequestWhenBodyIsEmpty() throws Exception {
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.username").exists());
    }

    @Test
    void getBadRequestWhenFieldsAreEmpty() throws Exception {
        CreateUserRequest request = new CreateUserRequest("", "");

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.username").exists());
    }

    @Test
    void getBadRequestWhenUsernameSizeIsLessThan6() throws Exception {
        CreateUserRequest request = new CreateUserRequest("bla", "");

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.username").exists());
    }
    @Test
    void getBadRequestWhenEmailValueIsNotValid() throws Exception {
        CreateUserRequest request = new CreateUserRequest("mathias", "mathias@");

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.email").exists());
    }

    @Test
    void testWhenFieldsAreValid() throws Exception {
        String email = "mathias@gmail.com";
        String username = "mathias";

        CreateUserRequest request = new CreateUserRequest(username, email);
        String body = objectMapper.writeValueAsString(request);

        when(userService.createUser(eq(request))).thenReturn(new UserDto(email));

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value(email));
    }
}