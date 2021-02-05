package de.neuefische.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    private String description;
    private UUID id;
    private String status;

    public ToDo(String description, String status){
        this.description = description;
        this.status = status;
    }

}
