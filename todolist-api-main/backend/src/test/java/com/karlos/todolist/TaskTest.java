package com.karlos.todolist;

import com.karlos.todolist.entities.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TaskTest {

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
        task.setTaskName("Estudar");
        task.setDescription("Estudar para a prova de matemática");

        assertEquals("Estudar", task.getTaskName());
        assertEquals("Estudar para a prova de matemática", task.getDescription());
    }

    @Test
    void testToString() {
        // Use o id gerado automaticamente para o toString (não é necessário definir explicitamente)
        Task task = new Task("Limpar a casa", "Fazer uma limpeza geral na sala e cozinha");

        // O ID não será 10L, então não precisa especificar
        String expected = "Task{id=null, taskName='Limpar a casa', description='Fazer uma limpeza geral na sala e cozinha'}";
        assertEquals(expected, task.toString());
    }

}
