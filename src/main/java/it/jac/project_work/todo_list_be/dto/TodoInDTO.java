package it.jac.project_work.todo_list_be.dto;

import java.time.LocalDate;

public class TodoInDTO {
    private String label;
    private String description;
    private Long categoryId;
    private Long userId;
    private LocalDate expDate;


    public TodoInDTO() {
    }

    public TodoInDTO(String label, String description ,Long categoryId, Long userId, LocalDate expDate) {
        this.label = label;
        this.description = description;
        this.categoryId = categoryId;
        this.userId = userId;
        this.expDate = expDate;
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


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
}
