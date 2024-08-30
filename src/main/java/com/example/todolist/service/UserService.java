package com.example.todolist.service;

import com.example.todolist.model.User;
import com.example.todolist.model.Authority;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.repository.AuthorityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService is a service class responsible for managing user-related operations
 * such as saving users and assigning roles to them. It interacts with the UserRepository
 * and AuthorityRepository to persist user and authority data.
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    /**
     * Constructor that initializes UserService with the necessary repositories.
     *
     * @param userRepository       Repository for managing user entities.
     * @param authorityRepository  Repository for managing user authorities.
     */
    @Autowired
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    /**
     * Saves the user entity to the database. The user's password is encrypted before being saved.
     * Additionally, assigns a default role (ROLE_USER) to the user.
     *
     * @param user The user entity to be saved.
     */
    @Transactional
    public void saveUser(User user) {
        // Encrypt the user's password and save the user entity
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        // Assign a default role (ROLE_USER) to the user
        authorityRepository.save(new Authority(user.getUsername(), "ROLE_USER"));

        // Log the successful saving of the user with the role
        logger.info("Користувач {} успішно збережений з роллю ROLE_USER", user.getUsername());
    }
}
