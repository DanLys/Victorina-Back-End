package org.victorina.data_entities.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.victorina.data_entities.AbstractAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Danil Lyskin at 15:06 05.02.2021
 */

@Entity
@Table(name = "users")
@EqualsAndHashCode(of = {}, callSuper = true)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractAccount {

    private Long score;

    /**
     * Количество очков пользователя.
     */
    @Column(name = "score")
    public Long getScore() {
        return score;
    }
}
