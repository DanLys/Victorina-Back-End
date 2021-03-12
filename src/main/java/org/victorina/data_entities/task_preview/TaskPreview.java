package org.victorina.data_entities.task_preview;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.victorina.data_entities.AbstractEntity;
import org.victorina.data_entities.task.Task;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Danil Lyskin at 21:07 08.03.2021
 */

@Entity
@Table(name = "task_preview")
@EqualsAndHashCode(of = {}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TaskPreview extends AbstractEntity {

    private String name;
    private Long hardLevel;
    private Set<Task> tasks = new HashSet<>();
    private Long countOfTasks;

    /**
     * Имя набора заданий.
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Уровень сложности.
     */
    @Column(name = "hard_level")
    public Long getHardLevel() {
        return hardLevel;
    }

    /**
     * Набор заданий.
     */
    @OneToMany(mappedBy = "taskPreview", fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<Task> getTasks() {
        return tasks;
    }

    /**
     * Количество заданий
     */
    @Column(name = "count")
    public Long getCountOfTasks() {
        return countOfTasks;
    }
}
