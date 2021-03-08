package org.victorina.mapper;

import org.springframework.stereotype.Component;
import org.victorina.data_entities.task_preview.TaskPreview;
import org.victorina.dto.TaskPreviewDTO;

/**
 * Created by Danil Lyskin at 22:07 08.03.2021
 */
@Component
public class TaskPreviewMapper extends AbstractMapper<TaskPreview, TaskPreviewDTO> {

    public TaskPreviewMapper() {
        super(TaskPreview.class, TaskPreviewDTO.class);
    }
}
