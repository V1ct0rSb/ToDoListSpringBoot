package br.com.victorbarreto.desafio_todo_list;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.victorbarreto.desafio_todo_list.entities.ToDoModel;
import br.com.victorbarreto.desafio_todo_list.repository.ToDoRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;


	 @Autowired
    private ToDoRepository toDoRepository;

	 @BeforeEach
    void cleanDatabase() {
        toDoRepository.deleteAll();
    }

	@Test
	void testCreateToDoSuccess() {
		var toDo = new ToDoModel("descricao ToDo 01", "toDo 01", 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(toDo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").value(length -> assertTrue((Integer) length >= 1))
				.jsonPath("$[0].nome").isEqualTo(toDo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(toDo.getDescricao())
				.jsonPath("$[0].prioridade").isEqualTo(toDo.getPrioridade())
				.jsonPath("$[0].realizado").isEqualTo(toDo.getRealizado());

	}

	@Test
	void testeCreateToDoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new ToDoModel("", "", 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

}
