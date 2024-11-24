package com.karlos.todolist;

import com.karlos.todolist.entities.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {

    @Test
    void testTaskConstructorAndGetters() {
        Task task = new Task("Comprar leite", "Comprar leite integral no mercado");
        assertNotNull(task);
        assertEquals("Comprar leite", task.getTaskName());
        assertEquals("Comprar leite integral no mercado", task.getDescription());
    }

    @Test
    void testSettersAndGetters() {
        Task task = new Task();
        task.setId(1L);
        task.setTaskName("Estudar");
        task.setDescription("Estudar para a prova de matemática");

        assertEquals(1L, task.getId());
        assertEquals("Estudar", task.getTaskName());
        assertEquals("Estudar para a prova de matemática", task.getDescription());
    }

    @Test
    void testToString() {
        Task task = new Task("Limpar a casa", "Fazer uma limpeza geral na sala e cozinha");
        task.setId(10L);

        String expected = "Task{id=10, taskName='Limpar a casa', description='Fazer uma limpeza geral na sala e cozinha'}";
        assertEquals(expected, task.toString());
    }

}