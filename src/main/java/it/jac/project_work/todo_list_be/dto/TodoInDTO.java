package it.jac.project_work.todo_list_be.dto;

import java.time.LocalDate;

public class TodoInDTO {
    private String label;
    private String description;
    private Long categoryId;
    private Long userId;
    private LocalDate expDate;

    private Long statusId;

    public TodoInDTO() {
    }

    public TodoInDTO(String label,Long statusId,  String description ,Long categoryId, Long userId, LocalDate expDate) {
        this.label = label;
        this.description = description;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.userId = userId;
        this.expDate = expDate;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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
