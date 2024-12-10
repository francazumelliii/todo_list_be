package it.jac.project_work.todo_list_be.repository;

import it.jac.project_work.todo_list_be.dto.TodoOutDTO;
import it.jac.project_work.todo_list_be.entity.Todo;
import it.jac.project_work.todo_list_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t WHERE t.user = :user AND t.status.label != 'DISABLED'")
    List<Todo> findAllByUser(User user);
}
