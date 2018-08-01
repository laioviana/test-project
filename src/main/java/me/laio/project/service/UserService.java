package me.laio.project.service;

import me.laio.project.domain.User;
import me.laio.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUsuarioByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

}
