package it.jac.project_work.todo_list_be.dto;

import it.jac.project_work.todo_list_be.entity.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TodoOutDTO {
    private Long id;
    private String label;
    private String description;
    private LocalDateTime createdAt;
    private LocalDate expDate;
    private UserOutDTO user;
    private CategoryOutDTO category;
    private StatusOutDTO status;

    public TodoOutDTO() {
    }

    public TodoOutDTO(Long id, String label, String description, LocalDateTime createdAt, LocalDate expDate, UserOutDTO user, CategoryOutDTO category, StatusOutDTO status) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.createdAt = createdAt;
        this.expDate = expDate;
        this.user = user;
        this.category = category;
        this.status = status;
    }
    public static TodoOutDTO build(Todo entity){
        TodoOutDTO dto = new TodoOutDTO();
        dto.setId(entity.getId());
        dto.setLabel(entity.getLabel());
        dto.setDescription(entity.getDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setExpDate(entity.getExpDate());
        dto.setUser(UserOutDTO.build(entity.getUser()));
        dto.setCategory(CategoryOutDTO.build(entity.getCategory()));
        dto.setStatus((StatusOutDTO.build(entity.getStatus())));
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public UserOutDTO getUser() {
        return user;
    }

    public void setUser(UserOutDTO user) {
        this.user = user;
    }

    public CategoryOutDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryOutDTO category) {
        this.category = category;
    }

    public StatusOutDTO getStatus() {
        return status;
    }

    public void setStatus(StatusOutDTO status) {
        this.status = status;
    }


}
