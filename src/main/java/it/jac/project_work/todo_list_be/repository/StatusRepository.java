package it.jac.project_work.todo_list_be.repository;

import it.jac.project_work.todo_list_be.entity.Status;
import it.jac.project_work.todo_list_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findByLabel(String label);
}
