package it.jac.project_work.todo_list_be.repository;

import it.jac.project_work.todo_list_be.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByLabel(String extra);
}
