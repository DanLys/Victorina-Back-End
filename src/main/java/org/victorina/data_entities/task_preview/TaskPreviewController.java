package org.victorina.data_entities.task_preview;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.victorina.config.SpringFoxConfig;
import org.victorina.dto.TaskPreviewDTO;

import java.util.List;

/**
 * Created by Danil Lyskin at 18:34 09.03.2021
 */

@Slf4j
@RestController
@Api(tags = {SpringFoxConfig.TASK_PREVIEW})
public class TaskPreviewController {

    private final TaskPreviewService taskPreviewService;

    @Autowired
    public TaskPreviewController(final TaskPreviewService taskPreviewService) {
        this.taskPreviewService = taskPreviewService;
    }

    @ApiOperation(value = "Download task preview",
            notes = "Download new task preview",
            response = TaskPreviewDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "api/task/preview/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskPreviewDTO> addTaskPreview(@RequestBody final TaskPreviewDTO taskPreviewDTO) {
        return ResponseEntity.ok(taskPreviewService.save(taskPreviewDTO));
    }

    @ApiOperation(value = "Delete task preview by id",
            notes = "Delete task preview by id")
    @RequestMapping(value = "api/task/preview/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") final Long id) {
        taskPreviewService.deleteById(id);
        return ResponseEntity.ok("{}");
    }

    @ApiOperation(value = "Get count of task preview",
            notes = "Count task preview")
    @RequestMapping(value = "api/task/preview/get", method = RequestMethod.GET)
    public ResponseEntity<List<TaskPreviewDTO>> getAllTaskPreview() {
        log.info("Getting previews");
        return ResponseEntity.ok(taskPreviewService.getAllTaskPreview());
    }
}
