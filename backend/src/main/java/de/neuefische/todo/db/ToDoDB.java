package de.neuefische.todo.db;

import de.neuefische.todo.model.ToDo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class ToDoDB {
    Map<UUID, ToDo> hashMapOfDb;
    public ToDoDB(){
        this.hashMapOfDb = new HashMap<>();
    }

    public Optional<List<ToDo>> get() {
        List<ToDo> list = new ArrayList<>(hashMapOfDb.values());
        return Optional.of(list);
    }

    public Optional<ToDo> post(ToDo newToDo) {
        ToDo returnValue = hashMapOfDb.putIfAbsent(newToDo.getId(), newToDo);
        if (returnValue == null){
            return Optional.of(newToDo);
        }
        return Optional.empty();
    }

    public Optional<ToDo> put(String id, ToDo updatedToDo) {
        ToDo returnValue = hashMapOfDb.put(UUID.fromString(id), updatedToDo);
            return Optional.of(updatedToDo);
    }

    public void delete(String id) {
        hashMapOfDb.remove(UUID.fromString(id));
    }
}
