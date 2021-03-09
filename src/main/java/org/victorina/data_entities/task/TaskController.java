package org.victorina.data_entities.task;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.victorina.dto.TaskDTO;

/**
 * Created by Danil Lyskin at 18:16 09.03.2021
 */

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }

    @ApiOperation(value = "Download task",
            notes = "Download new task",
            response = TaskDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "api/task/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> addTask(@RequestBody final TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.save(taskDTO));
    }

    @ApiOperation(value = "Find task by id",
            notes = "Find task by id",
            response = TaskDTO.class)
    @RequestMapping(value = "api/task/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @ApiOperation(value = "Delete task by id",
            notes = "Delete task by id")
    @RequestMapping(value = "api/task/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") final Long id) {
        taskService.deleteById(id);
        return ResponseEntity.ok("{}");
    }
}
