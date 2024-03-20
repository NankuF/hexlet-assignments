package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("")
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream().map(t -> taskMapper.map(t)).toList();
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        return taskMapper.map(task);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@RequestBody @Valid TaskCreateDTO entity) {
        var task = taskMapper.map(entity);
        taskRepository.save(task);

        return taskMapper.map(task);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO updateTask(@PathVariable long id, @RequestBody @Valid TaskUpdateDTO entity) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        taskMapper.update(entity, task);

        var oldUser = userRepository.findById(task.getAssignee().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        System.out.println(String.format("OLDUSER TASK: %s", oldUser.getTasks().size()));
        oldUser.removeTask(task);
        System.out
                .println(String.format("OLDUSER TASK after REMOVE: %s", oldUser.getTasks().size()));
        var newUser = userRepository.findById(entity.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        System.out.println(String.format("NEWUSER TASK: %s", newUser.getTasks().size()));
        newUser.addTask(task);
        System.out.println(String.format("NEWUSER TASK AFTER ADD: %s", newUser.getTasks().size()));
        userRepository.save(oldUser);
        userRepository.save(newUser);

        var task1 = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        var taskDTO = taskMapper.map(task1);
        // return taskDTO;
        // var task = taskRepository.findById(id)
        // .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        // var user = userRepository.findById(taskData.getAssigneeId())
        // .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // taskMapper.update(taskData, task);
        // task.setAssignee(user);
        // taskRepository.save(task);
        // var taskDTO = taskMapper.map(task);
        return taskDTO;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        var user = task.getAssignee();
        System.out.println(String.format("NEWUSER TASK: %s", user.getTasks().size()));
        user.removeTask(task);
        System.out.println(String.format("NEWUSER TASK AFTER REMOVE: %s", user.getTasks().size()));
        userRepository.save(user);
    }
    // END
}
