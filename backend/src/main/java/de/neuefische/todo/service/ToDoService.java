package de.neuefische.todo.service;

import de.neuefische.todo.db.ToDoDB;
import de.neuefische.todo.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ToDoService {

    private ToDoDB toDoDB;

    @Autowired
    public ToDoService(ToDoDB toDoDB) {
        this.toDoDB = toDoDB;
    }

    public Optional<List<ToDo>> getAllToDos() {
        Optional<List<ToDo>> listOfAllToDos = toDoDB.get();
        return listOfAllToDos;
    }

    public Optional<ToDo> createToDo(ToDo newToDo) {
        UUID uuid = UUID.randomUUID();
        newToDo.setId(uuid);
        Optional<ToDo> respondSingleToDo = toDoDB.post(newToDo);
        return respondSingleToDo;
    }

    public Optional<ToDo> updateToDo(String id, ToDo updatedToDo) {
        Optional<ToDo> updatedSingleToDo = toDoDB.put(id, updatedToDo);
        return updatedSingleToDo;
    }

    public void deleteToDo(String id) {
        toDoDB.delete(id);
    }


}
