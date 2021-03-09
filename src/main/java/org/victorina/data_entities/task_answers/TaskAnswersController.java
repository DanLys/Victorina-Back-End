package org.victorina.data_entities.task_answers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.victorina.dto.TaskAnswersDTO;

import java.util.List;

/**
 * Created by Danil Lyskin at 18:28 09.03.2021
 */

@RestController
public class TaskAnswersController {

    private final TaskAnswersService taskAnswersService;

    @Autowired
    public TaskAnswersController(final TaskAnswersService taskAnswersService) {
        this.taskAnswersService = taskAnswersService;
    }

    @ApiOperation(value = "Download task answer",
            notes = "Download new answer for task",
            response = TaskAnswersDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "api/task/answer/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskAnswersDTO> addTaskAnswer(@RequestBody final TaskAnswersDTO taskAnswersDTO) {
        return ResponseEntity.ok(taskAnswersService.save(taskAnswersDTO));
    }

    @ApiOperation(value = "Find all answers for task",
            notes = "Find all answers for task by task id",
            response = TaskAnswersDTO.class)
    @RequestMapping(value = "api/task/answer/find/all/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<TaskAnswersDTO>> getAllAnswersForTask(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(taskAnswersService.findByTaskId(id));
    }

    @ApiOperation(value = "Delete answer by id",
            notes = "Delete answer by id")
    @RequestMapping(value = "api/task/answer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") final Long id) {
        taskAnswersService.deleteById(id);
        return ResponseEntity.ok("{}");
    }
}
