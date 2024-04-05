package bj.hecm.demospringconcepts.dto;

import java.time.LocalDateTime;

public record GetAllUsersDto(LocalDateTime start, LocalDateTime end, int page, int size) {
}
