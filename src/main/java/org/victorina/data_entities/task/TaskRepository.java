package org.victorina.data_entities.task;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Danil Lyskin at 20:55 08.03.2021
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
