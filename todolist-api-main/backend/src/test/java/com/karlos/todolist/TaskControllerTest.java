package com.karlos.todolist;

import com.karlos.todolist.controller.TaskController;
import com.karlos.todolist.entities.Task;
import com.karlos.todolist.services.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @Test
    public void testCreateTask_success() {
        // Arrange
        Task taskToCreate = new Task();
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("Task created successfully");
        Mockito.when(taskService.createTask(taskToCreate)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> actualResponse = taskController.createTask(taskToCreate);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testCreateTask_failure() {
        // Arrange
        Task taskToCreate = new Task();
        Mockito.when(taskService.createTask(taskToCreate)).thenThrow(RuntimeException.class);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> taskController.createTask(taskToCreate));
    }

    @Test
    public void testGetAllTasks() {
        // Arrange
        List<Task> expectedTasks = List.of(new Task(), new Task());
        Mockito.when(taskService.listAllTasks()).thenReturn(expectedTasks);

        // Act
        List<Task> actualTasks = taskController.getAllTasks();

        // Assert
        assertEquals(expectedTasks, actualTasks);
    }

    @Test
    public void testGetTaskById_success() {
        // Arrange
        Long taskId = 1L;
        Task expectedTask = new Task();
        Mockito.when(taskService.findTaskById(taskId)).thenReturn(ResponseEntity.ok(expectedTask));

        // Act
        ResponseEntity<Task> actualResponse = taskController.getTaskById(taskId);

        // Assert
        assertEquals(expectedTask, actualResponse.getBody());
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }

    @Test
    public void testGetTaskById_notFound() {
        // Arrange
        Long taskId = 1L;
        Mockito.when(taskService.findTaskById(taskId)).thenReturn(ResponseEntity.notFound().build());

        // Act
        ResponseEntity<Task> actualResponse = taskController.getTaskById(taskId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actualResponse.getStatusCode());
    }

    @Test
    public void testUpdateTaskById_success() {
        // Arrange
        Long taskId = 1L;
        Task updatedTask = new Task();
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("Task updated successfully");
        Mockito.when(taskService.updateTaskById(updatedTask, taskId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> actualResponse = taskController.updateTaskById(taskId, updatedTask);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testUpdateTaskById_failure() {
        // Arrange
        Long taskId = 1L;
        Task updatedTask = new Task();
        Mockito.when(taskService.updateTaskById(updatedTask, taskId)).thenThrow(RuntimeException.class);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> taskController.updateTaskById(taskId, updatedTask));
    }

    @Test
    public void testDeleteTaskById_success() {
        // Arrange
        Long taskId = 1L;
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("Task deleted successfully");
        Mockito.when(taskService.deleteTaskById(taskId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> actualResponse = taskController.deleteTaskById(taskId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testDeleteTaskById_failure() {
        // Arrange
        Long taskId = 1L;
        Mockito.when(taskService.deleteTaskById(taskId)).thenThrow(RuntimeException.class);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> taskController.deleteTaskById(taskId));
    }

}