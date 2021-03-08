package org.victorina.data_entities.task_answers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.victorina.data_entities.AbstractEntity;
import org.victorina.data_entities.task.Task;

import javax.persistence.*;

/**
 * Created by Danil Lyskin at 15:21 05.02.2021
 */

@Entity
@Table(name = "task_answers")
@EqualsAndHashCode(of = {}, callSuper = true)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskAnswers extends AbstractEntity {

    private String answer;
    private Boolean isTrue;
    private Task task;

    /**
     * Вариант ответа.
     */
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    /**
     * Верность ответа.
     */
    @Column(name = "is_true")
    public Boolean getIsTrue() {
        return isTrue;
    }

    /**
     * Задание, к которому ответ.
     */
    @Cascade({CascadeType.SAVE_UPDATE})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    public Task getTask() {
        return task;
    }
}
