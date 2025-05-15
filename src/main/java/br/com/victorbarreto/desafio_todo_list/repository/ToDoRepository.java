package br.com.victorbarreto.desafio_todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorbarreto.desafio_todo_list.entities.ToDoModel;

public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {

}