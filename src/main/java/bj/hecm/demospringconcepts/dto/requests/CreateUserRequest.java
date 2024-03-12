package bj.hecm.demospringconcepts.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateUserRequest(
        @NotBlank
        @Size(min = 6)
        String username,
        @NotBlank
        @Email
        String email
) {
}
