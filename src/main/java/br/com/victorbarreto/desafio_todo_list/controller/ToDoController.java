package br.com.victorbarreto.desafio_todo_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorbarreto.desafio_todo_list.entities.ToDoModel;
import br.com.victorbarreto.desafio_todo_list.service.ToDoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity<List<ToDoModel>> create(@RequestBody @Valid ToDoModel obj) {
        List<ToDoModel> createdList = toDoService.create(obj);
        return ResponseEntity.ok().body(createdList);
    }

    @GetMapping
    public ResponseEntity<List<ToDoModel>> list() {
        List<ToDoModel> list = toDoService.list();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping
    public ResponseEntity<List<ToDoModel>> update(@RequestBody ToDoModel obj) {
        List<ToDoModel> update = toDoService.update(obj);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        toDoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}