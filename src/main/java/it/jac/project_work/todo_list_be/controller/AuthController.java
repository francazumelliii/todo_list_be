package it.jac.project_work.todo_list_be.controller;


import it.jac.project_work.todo_list_be.dto.AuthenticationDTO;
import it.jac.project_work.todo_list_be.dto.UserOutDTO;
import it.jac.project_work.todo_list_be.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    public AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public UserOutDTO login(@RequestBody AuthenticationDTO dto){
        return this.authService.login(dto);
    }

}
