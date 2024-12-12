package it.jac.project_work.todo_list_be.service;


import it.jac.project_work.todo_list_be.dto.StatusOutDTO;
import it.jac.project_work.todo_list_be.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {

    @Autowired
    private final StatusRepository statusRepository;
    public StatusService (StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    public List<StatusOutDTO> findAll(){
        return this.statusRepository.findAll()
                .stream().map(StatusOutDTO::build).collect(Collectors.toList());
    }
}
