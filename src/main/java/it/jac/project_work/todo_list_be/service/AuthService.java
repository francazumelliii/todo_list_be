package it.jac.project_work.todo_list_be.service;

import it.jac.project_work.todo_list_be.dto.AuthenticationDTO;
import it.jac.project_work.todo_list_be.dto.UserOutDTO;
import it.jac.project_work.todo_list_be.entity.User;
import it.jac.project_work.todo_list_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    @Autowired
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public UserOutDTO login(AuthenticationDTO dto){
        if(dto.getEmail().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: email");
        if(dto.getPassword().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: password");

        User user = this.userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User entity not found"));

        if(!user.getPassword().equals(dto.getPassword())) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");

        return UserOutDTO.build(user);
    }
}
