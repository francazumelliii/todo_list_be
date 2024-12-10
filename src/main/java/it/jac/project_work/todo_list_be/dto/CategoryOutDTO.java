package it.jac.project_work.todo_list_be.dto;

import it.jac.project_work.todo_list_be.entity.Category;

public class CategoryOutDTO {
    private Long id;
    private String label;
    private String description;


    public CategoryOutDTO(){

    }

    public CategoryOutDTO(Long id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
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

    public static CategoryOutDTO build(Category entity){
        CategoryOutDTO dto = new CategoryOutDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setLabel(entity.getLabel());
        return dto;
    }
}
