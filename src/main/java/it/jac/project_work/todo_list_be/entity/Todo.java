package it.jac.project_work.todo_list_be.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Todo {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="label")
    private String label;
    @Column(name="description")
    private String description;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="exp_date")
    private LocalDate expDate;
    @JoinColumn(name="user_id")
    @ManyToOne()
    private User user;

    @JoinColumn(name="category_id")
    @ManyToOne()
    private Category category;

    @JoinColumn(name="status_id")
    @ManyToOne()
    private Status status;

    public Todo(Long id, String label, String description, LocalDateTime createdAt, LocalDate expDate, User user, Category category, Status status) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.createdAt = createdAt;
        this.expDate = expDate;
        this.user = user;
        this.category = category;
        this.status = status;
    }

    public Todo() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
