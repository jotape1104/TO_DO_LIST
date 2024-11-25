package com.karlos.todolist;
import com.karlos.todolist.entities.*;
import com.karlos.todolist.repositories.TaskRepository;
import com.karlos.todolist.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        ResponseEntity<String> response = taskService.createTask(task);

        verify(taskRepository, times(1)).save(task);
        assertEquals(ResponseEntity.ok("Tarefa criada com sucesso!"), response);
    }

    @Test
    void testListAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.listAllTasks();

        verify(taskRepository, times(1)).findAll();
        assertEquals(tasks, result);
    }

    @Test
    void testFindTaskByIdSuccess() {
        Task task = new Task();
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        ResponseEntity<Task> response = taskService.findTaskById(1L);

        verify(taskRepository, times(1)).findById(1L);
        assertEquals(ResponseEntity.ok().body(task), response);
    }

    @Test
    void testFindTaskByIdNotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Task> response = taskService.findTaskById(1L);

        verify(taskRepository, times(1)).findById(1L);
        assertEquals(ResponseEntity.notFound().build(), response);
    }

    @Test
    void testUpdateTaskByIdSuccess() {
        Task task = new Task();
        task.setTaskName("Nova Tarefa");
        task.setDescription("Descrição da Tarefa");

        Task taskToUpdate = new Task();
        when(taskRepository.findById(1L)).thenReturn(Optional.of(taskToUpdate));
        when(taskRepository.save(taskToUpdate)).thenReturn(taskToUpdate);

        ResponseEntity<String> response = taskService.updateTaskById(task, 1L);

        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).save(taskToUpdate);
        assertEquals(ResponseEntity.ok("Tarefa atualizada com sucesso!"), response);
    }

    @Test
    void testUpdateTaskByIdNotFound() {
        Task task = new Task();
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<String> response = taskService.updateTaskById(task, 1L);

        verify(taskRepository, times(1)).findById(1L);
        assertEquals(ResponseEntity.status(404).body("Tarefa não encontrada!"), response);
    }

    @Test
    void testDeleteTaskByIdSuccess() {
        Task task = new Task();
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        doNothing().when(taskRepository).deleteById(1L);

        ResponseEntity<String> response = taskService.deleteTaskById(1L);

        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).deleteById(1L);
        assertEquals(ResponseEntity.ok("Tarefa excluída com sucesso!"), response);
    }

    @Test
    void testDeleteTaskByIdNotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<String> response = taskService.deleteTaskById(1L);

        verify(taskRepository, times(1)).findById(1L);
        assertEquals(ResponseEntity.status(404).body("Tarefa não encontrada!"), response);
    }
}


