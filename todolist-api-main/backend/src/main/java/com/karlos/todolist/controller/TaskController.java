package com.karlos.todolist.controller;

import com.karlos.todolist.entities.Task;
import com.karlos.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")  // Certifique-se de que o CORS está configurado corretamente
@RestController
@RequestMapping("/todolist/a3")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.listAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<String> updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskById(task, id);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }

    // Opcional: Endpoint para tratar requisições OPTIONS
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.OPTIONS)
    public void handleOptionsRequest() {
        // Este método pode ser usado para lidar com requisições OPTIONS (pré-vôo CORS)
    }
}
