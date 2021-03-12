package org.victorina.data_entities.task_preview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victorina.data_entities.AbstractEntity;
import org.victorina.dto.TaskPreviewDTO;
import org.victorina.mapper.TaskPreviewMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Danil Lyskin at 22:06 08.03.2021
 */

@Service
public class TaskPreviewService {

    private final TaskPreviewRepository taskPreviewRepository;
    private final TaskPreviewMapper taskPreviewMapper;

    @Autowired
    public TaskPreviewService(final TaskPreviewRepository taskPreviewRepository,
                              final TaskPreviewMapper taskPreviewMapper) {
        this.taskPreviewRepository = taskPreviewRepository;
        this.taskPreviewMapper = taskPreviewMapper;
    }

    /**
     * Сохраняет представление набора заданий.
     * @param dto Объектное представление набора заданий.
     * @return Объектное представление набора заданий {@link TaskPreviewDTO}
     */
    public TaskPreviewDTO save(TaskPreviewDTO dto) {
        return taskPreviewMapper.toDto(taskPreviewRepository.save(taskPreviewMapper.toEntity(dto)));
    }

    /**
     * Получение представлений.
     * Номера необходимых представлений.
     * @return представление набора заданий {@link TaskPreviewDTO}
     */
    public List<TaskPreviewDTO> findByIndex(Long from, Long to) {
        List<TaskPreviewDTO> previews = taskPreviewRepository.findAll().stream()
                .sorted(Comparator.comparing(AbstractEntity::getId))
                .map(taskPreviewMapper::toDto).collect(Collectors.toList());

        return previews.subList(from.intValue(), (int) Math.max(previews.size(), to));
    }

    /**
     * Удаление представления по id.
     * @param id id представления.
     */
    public void deleteById(Long id) {
        taskPreviewRepository.deleteById(id);
    }

    /**
     * Получение представлений.
     * @return представления {@link TaskPreviewDTO}
     */
    public List<TaskPreviewDTO> getAllTaskPreview() {
        return taskPreviewRepository.findAll().stream().map(taskPreviewMapper::toDto).collect(Collectors.toList());
    }
}
