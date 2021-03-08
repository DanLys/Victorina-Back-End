package org.victorina.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.victorina.data_entities.task.TaskRepository;
import org.victorina.data_entities.task_answers.TaskAnswers;
import org.victorina.dto.TaskAnswersDTO;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by Danil Lyskin at 21:02 08.03.2021
 */

@Component
public class TaskAnswersMapper extends AbstractMapper<TaskAnswers, TaskAnswersDTO> {

    private final ModelMapper mapper;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskAnswersMapper(final ModelMapper mapper,
                             final TaskRepository taskRepository) {
        super(TaskAnswers.class, TaskAnswersDTO.class);
        this.mapper = mapper;
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(TaskAnswers.class, TaskAnswersDTO.class)
                .addMappings(m -> m.skip(TaskAnswersDTO::setTaskId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(TaskAnswersDTO.class, TaskAnswers.class)
                .addMappings(m -> m.skip(TaskAnswers::setTask)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(TaskAnswers source, TaskAnswersDTO destination) {
        destination.setTaskId(getTaskId(source));
    }

    private Long getTaskId(TaskAnswers source) {
        return Objects.isNull(source) || Objects.isNull(source.getTask()) ? null : source.getTask().getId();
    }

    @Override
    void mapSpecificFields(TaskAnswersDTO source, TaskAnswers destination) {
        destination.setTask(taskRepository.findById(source.getTaskId()).orElse(null));
    }
}

