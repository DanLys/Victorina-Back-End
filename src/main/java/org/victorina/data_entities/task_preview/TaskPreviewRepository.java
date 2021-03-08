package org.victorina.data_entities.task_preview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.victorina.data_entities.task.Task;

import java.util.List;
import java.util.Optional;

/**
 * Created by Danil Lyskin at 21:50 08.03.2021
 */
public interface TaskPreviewRepository extends JpaRepository<TaskPreview, Long> {
}
