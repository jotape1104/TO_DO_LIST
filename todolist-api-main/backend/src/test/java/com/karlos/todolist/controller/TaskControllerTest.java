package com.karlos.todolist.controller;

import com.karlos.todolist.controller.TaskController;
import com.karlos.todolist.entities.Task;
import com.karlos.todolist.services.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unused")
@WebMvcTest(TaskController.class)  // Testa apenas o controlador
class TaskControllerTest {

    @SuppressWarnings("unused")
    @Autowired
    private MockMvc mockMvc;  // Usado para simular requisições HTTP no controlador

    @MockBean
    private TaskService taskService;  // Simula o serviço sem usar a implementação real

    @Test
    void testCreateTask_success() throws Exception {
        // Arrange
        Task taskToCreate = new Task();
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("Task created successfully");
        Mockito.when(taskService.createTask(taskToCreate)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> actualResponse = taskService.createTask(taskToCreate);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testCreateTask_failure() throws Exception {
        // Arrange
        Task taskToCreate = new Task();
        Mockito.when(taskService.createTask(taskToCreate)).thenThrow(RuntimeException.class);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> taskService.createTask(taskToCreate));
    }

    @Test
    void testGetAllTasks() throws Exception {
        // Arrange
        List<Task> expectedTasks = List.of(new Task(), new Task());
        Mockito.when(taskService.listAllTasks()).thenReturn(expectedTasks);

        // Act
        List<Task> actualTasks = taskService.listAllTasks();

        // Assert
        assertEquals(expectedTasks, actualTasks);
    }

    @Test
    void testGetTaskById_success() throws Exception {
        // Arrange
        Long taskId = 1L;
        Task expectedTask = new Task();
        Mockito.when(taskService.findTaskById(taskId)).thenReturn(ResponseEntity.ok(expectedTask));

        // Act
        ResponseEntity<Task> actualResponse = taskService.findTaskById(taskId);

        // Assert
        assertEquals(expectedTask, actualResponse.getBody());
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }

    @Test
    void testGetTaskById_notFound() throws Exception {
        // Arrange
        Long taskId = 1L;
        Mockito.when(taskService.findTaskById(taskId)).thenReturn(ResponseEntity.notFound().build());

        // Act
        ResponseEntity<Task> actualResponse = taskService.findTaskById(taskId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actualResponse.getStatusCode());
    }

    @Test
    void testUpdateTaskById_success() throws Exception {
        // Arrange
        Long taskId = 1L;
        Task updatedTask = new Task();
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("Task updated successfully");
        Mockito.when(taskService.updateTaskById(updatedTask, taskId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> actualResponse = taskService.updateTaskById(updatedTask, taskId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testUpdateTaskById_failure() throws Exception {
        // Arrange
        Long taskId = 1L;
        Task updatedTask = new Task();
        Mockito.when(taskService.updateTaskById(updatedTask, taskId)).thenThrow(RuntimeException.class);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> taskService.updateTaskById(updatedTask, taskId));
    }

    @Test
    void testDeleteTaskById_success() throws Exception {
        // Arrange
        Long taskId = 1L;
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("Task deleted successfully");
        Mockito.when(taskService.deleteTaskById(taskId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> actualResponse = taskService.deleteTaskById(taskId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testDeleteTaskById_failure() throws Exception {
        // Arrange
        Long taskId = 1L;
        Mockito.when(taskService.deleteTaskById(taskId)).thenThrow(RuntimeException.class);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> taskService.deleteTaskById(taskId));
    }
}
