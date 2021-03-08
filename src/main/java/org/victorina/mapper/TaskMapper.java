package org.victorina.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.victorina.data_entities.task.Task;
import org.victorina.data_entities.task_preview.TaskPreviewRepository;
import org.victorina.dto.TaskDTO;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by Danil Lyskin at 20:53 08.03.2021
 */
@Component
public class TaskMapper extends AbstractMapper<Task, TaskDTO> {

    private final ModelMapper mapper;
    private final TaskPreviewRepository taskPreviewRepository;

    @Autowired
    public TaskMapper(final ModelMapper mapper,
                             final TaskPreviewRepository taskPreviewRepository) {
        super(Task.class, TaskDTO.class);
        this.mapper = mapper;
        this.taskPreviewRepository = taskPreviewRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Task.class, TaskDTO.class)
                .addMappings(m -> m.skip(TaskDTO::setTaskPreviewId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(TaskDTO.class, Task.class)
                .addMappings(m -> m.skip(Task::setTaskPreview)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Task source, TaskDTO destination) {
        destination.setTaskPreviewId(getTaskPreviewId(source));
    }

    private Long getTaskPreviewId(Task source) {
        return Objects.isNull(source) || Objects.isNull(source.getTaskPreview()) ? null : source.getTaskPreview().getId();
    }

    @Override
    void mapSpecificFields(TaskDTO source, Task destination) {
        destination.setTaskPreview(taskPreviewRepository.findById(source.getTaskPreviewId()).orElse(null));
    }
}
