package org.victorina.data_entities.task_answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victorina.dto.TaskAnswersDTO;
import org.victorina.dto.TaskDTO;
import org.victorina.mapper.TaskAnswersMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Danil Lyskin at 21:52 08.03.2021
 */
@Service
public class TaskAnswersService {

    private final TaskAnswersRepository taskAnswersRepository;
    private final TaskAnswersMapper taskAnswersMapper;

    @Autowired
    public TaskAnswersService(final TaskAnswersRepository taskAnswersRepository,
                              final TaskAnswersMapper taskAnswersMapper) {
        this.taskAnswersRepository = taskAnswersRepository;
        this.taskAnswersMapper = taskAnswersMapper;
    }

    /**
     * Сохраняет ответ на вопрос.
     * @param dto Объектное представление ответа на вопрос.
     * @return Объектное представление ответа на вопрос {@link TaskAnswersDTO}
     */
    public TaskAnswersDTO save(TaskAnswersDTO dto) {
        return taskAnswersMapper.toDto(taskAnswersRepository.save(taskAnswersMapper.toEntity(dto)));
    }

    /**
     * Получение всех ответов для вопроса.
     * @param id id вопроса.
     * @return Варианты ответа на вопрос {@link TaskAnswersDTO}
     */
    public List<TaskAnswersDTO> findByTask(Long id) {
        return taskAnswersRepository.findAllTaskAnswersByTaskId(id).stream()
                .map(taskAnswersMapper::toDto).collect(Collectors.toList());
    }

    /**
     * Удаление ответа по id.
     * @param id id вопроса.
     */
    public void deleteById(Long id) {
        taskAnswersRepository.deleteById(id);
    }
}
