package bj.hecm.demospringconcepts.repositories;

import bj.hecm.demospringconcepts.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.createdAt >= :start AND u.createdAt <= :end")
    List<User> getAllUsers(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
