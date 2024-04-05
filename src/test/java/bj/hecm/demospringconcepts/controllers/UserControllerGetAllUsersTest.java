package bj.hecm.demospringconcepts.controllers;

import bj.hecm.demospringconcepts.dto.GetAllUsersDto;
import bj.hecm.demospringconcepts.dto.UserDto;
import bj.hecm.demospringconcepts.repositories.UserRepository;
import bj.hecm.demospringconcepts.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerGetAllUsersTest {
    @MockBean
    UserRepository userRepository;
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getBadRequestWhenStartAndEndAreEmpties() throws Exception {
        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getRightResponse() throws Exception {
        GetAllUsersDto dto = new GetAllUsersDto(LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(1), 0, 10);

        when(userService.getAllUsers(dto)).thenReturn(Collections.singletonList(new UserDto("johnDoe@gmail.com")));

        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("start", dto.start().format(DateTimeFormatter.ISO_DATE_TIME));
        params.add("end", dto.end().format(DateTimeFormatter.ISO_DATE_TIME));
        params.add("page", String.valueOf(dto.page()));
        params.add("size", String.valueOf(dto.size()));

        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParams(params))
                .andExpect(status().isOk());
    }
}
