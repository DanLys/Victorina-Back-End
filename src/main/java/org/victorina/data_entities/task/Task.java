package org.victorina.data_entities.task;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.victorina.attributs.TaskType;
import org.victorina.data_entities.AbstractEntity;
import org.victorina.data_entities.task_answers.TaskAnswers;
import org.victorina.data_entities.task_preview.TaskPreview;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Danil Lyskin at 15:14 05.02.2021
 */

@Entity
@Table(name = "task")
@EqualsAndHashCode(of = {}, callSuper = true)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends AbstractEntity {

    private String name;
    private String descriptions;
    private TaskType type;
    private Set<TaskAnswers> answers = new HashSet<>();
    private TaskPreview taskPreview;
    private Boolean flagOfCountAnswers;

    /**
     * Имя задания.
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Описание задания.
     */
    @Column(name = "descriptions")
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * Ответы.
     */
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<TaskAnswers> getAnswers() {
        return answers;
    }

    /**
     * Тип задания.
     */
    @Column(name = "type")
    public TaskType getType() {
        return type;
    }

    /**
     * Задание к набору.
     */
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_preview_id")
    public TaskPreview getTaskPreview() {
        return taskPreview;
    }

    /**
     * Флаг однозначного/неоднозначного выбора ответа.
     */
    @Column(name = "flag_of_count_answers")
    public Boolean getFlagOfCountAnswers() {
        return flagOfCountAnswers;
    }
}
