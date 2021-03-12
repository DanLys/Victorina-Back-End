package org.victorina.data_entities.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victorina.dto.TaskDTO;
import org.victorina.exceptions.task.ApiTaskNotFoundException;
import org.victorina.mapper.TaskMapper;

import java.util.Optional;

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
     * Получение задания по id.
     * @param id id задания.
     * @return объектное представление задания {@link TaskDTO}
     */
    public TaskDTO findById(Long id) {
        Optional<Task> op = taskRepository.findById(id);
        if (op.isPresent()) {
            return taskMapper.toDto(op.get());
        }

        throw new ApiTaskNotFoundException(String.format("Task with id: %d not found", id));
    }

    /**
     * Удаление задания по id.
     * @param id id задания.
     */
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
