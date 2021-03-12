package org.victorina.data_entities.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victorina.data_entities.AbstractEntity;
import org.victorina.dto.TaskDTO;
import org.victorina.exceptions.task.ApiTaskNotFoundException;
import org.victorina.mapper.TaskMapper;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Danil Lyskin at 22:35 08.03.2021
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(final TaskRepository taskRepository,
                       final TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    /**
     * Сохраняет задание.
     * @param dto Объектное представление задания.
     * @return Объектное представление задания {@link TaskDTO}
     */
    public TaskDTO save(TaskDTO dto) {
        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(dto)));
    }

    /**
     * Получение задания по index и id представления.
     * @param index номер задания.
     * @param id id представления.
     * @return Объектное представления задания.
     */
    public TaskDTO findByIndexAndId(int index, Long id) {
        List<TaskDTO> tasks = taskRepository.findAllByTaskPreviewId(id).stream().
                sorted(Comparator.comparing(AbstractEntity::getId))
                .map(taskMapper::toDto).collect(Collectors.toList());

        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }

        throw new ApiTaskNotFoundException(String.format("Task with id: %d and index: %d not found", id, index));
    }

    /**
     * Удаление задания по id.
     * @param id id задания.
     */
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
