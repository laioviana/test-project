package me.laio.project.repository;

import me.laio.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByLogin(String login);
}
