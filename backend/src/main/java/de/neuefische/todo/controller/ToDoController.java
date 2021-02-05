package de.neuefische.todo.controller;

import de.neuefische.todo.model.ToDo;
import de.neuefische.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/todo")
public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;

    }

    @GetMapping
    public List<ToDo> getAllToDos(){
        Optional<List<ToDo>> listOfAllToDos = toDoService.getAllToDos();
        if(listOfAllToDos.isPresent()) {
            return listOfAllToDos.get();
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo newToDo){
        Optional<ToDo> addedToDo = toDoService.createToDo(newToDo);
        if (addedToDo.isPresent()){
            return addedToDo.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("{id}")
    public ToDo updateToDo(@PathVariable String id, @RequestBody ToDo updatedToDo){
        Optional<ToDo> respondToDo = toDoService.updateToDo(id, updatedToDo);
        if (respondToDo.isPresent()){
            return respondToDo.get();
        }
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @DeleteMapping("{id}")
    public void deleteToDo(@PathVariable String id){
        toDoService.deleteToDo(id);
    }
}
