package org.victorina.data_entities.task_preview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Danil Lyskin at 21:50 08.03.2021
 */
@Repository
public interface TaskPreviewRepository extends JpaRepository<TaskPreview, Long> {
}
