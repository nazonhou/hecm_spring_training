package bj.hecm.demospringconcepts.repositories;

import bj.hecm.demospringconcepts.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
