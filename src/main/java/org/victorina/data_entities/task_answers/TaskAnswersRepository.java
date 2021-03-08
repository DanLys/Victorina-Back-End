package org.victorina.data_entities.task_answers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.victorina.dto.TaskDTO;

import java.util.Optional;

/**
 * Created by Danil Lyskin at 21:50 08.03.2021
 */
public interface TaskAnswersRepository extends JpaRepository<TaskAnswers, Long> {

    Optional<TaskAnswers> findAllTaskAnswersByTaskId(Long taskId);
}
