package it.jac.project_work.todo_list_be.dto;

import it.jac.project_work.todo_list_be.entity.User;

public class UserOutDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public UserOutDTO() {
    }

    public UserOutDTO(Long id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserOutDTO build(User entity){
       UserOutDTO dto = new UserOutDTO();
       dto.setId(entity.getId());
       dto.setName(entity.getName());
       dto.setSurname(entity.getSurname());
       dto.setEmail(entity.getEmail());
       dto.setPassword(entity.getPassword());
       return dto;
    }
}
