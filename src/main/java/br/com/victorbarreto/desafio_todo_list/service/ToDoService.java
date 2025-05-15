package br.com.victorbarreto.desafio_todo_list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.victorbarreto.desafio_todo_list.entities.ToDoModel;
import br.com.victorbarreto.desafio_todo_list.repository.ToDoRepository;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    // Inserindo dados
    public List<ToDoModel> create(ToDoModel obj) {
        toDoRepository.save(obj);
        return list();
    }

    // Listando Tudo em Ordem de prioridade e nome
    public List<ToDoModel> list() {
        Sort sortByPrioridade = Sort.by(Sort.Direction.DESC, "prioridade");
        Sort sortByNome = Sort.by(Sort.Direction.ASC, "nome");

        Sort sort = sortByPrioridade.and(sortByNome);

        return toDoRepository.findAll(sort);
    }

    //Atualizando Tudo
    public List<ToDoModel> update(ToDoModel obj) {
        toDoRepository.save(obj);
        return list();
    }


    // Removendo pelo Id
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }
}