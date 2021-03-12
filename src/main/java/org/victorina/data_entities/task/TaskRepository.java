package org.victorina.data_entities.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Danil Lyskin at 20:55 08.03.2021
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTaskPreviewId(Long id);
}
