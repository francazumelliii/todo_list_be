package it.jac.project_work.todo_list_be.dto;

import it.jac.project_work.todo_list_be.entity.Status;

public class StatusOutDTO {
    private Long id;
    private String label;

    public StatusOutDTO(){}

    public StatusOutDTO(Long id, String label) {
        this.id = id;
        this.label = label;
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

    public static StatusOutDTO build(Status entity){
        StatusOutDTO dto = new StatusOutDTO();
        dto.setLabel(entity.getLabel());
        dto.setId(entity.getId());
        return dto;
    }
}
