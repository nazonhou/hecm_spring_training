package bj.hecm.demospringconcepts.dto.requests;

import lombok.Builder;

@Builder
public record CreateUserRequest(String username, String email) {
}
