package org.victorina.data_entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

/**
 * Created by Danil Lyskin at 15:09 05.02.2021
 */

@MappedSuperclass
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractAccount extends AbstractEntity {

    protected String token;
    protected String login;

    /**
     * Токен закрепленный за аккаунтом.
     */
    @Column(name = "token", unique = true, length = 512)
    public String getToken() {
        return token;
    }

    /**
     * Логин прикрепленный к аккаунту.
     */
    @NotBlank(message = "Логин не может быть пустым")
    @Column(name = "login", unique = true)
    public String getLogin() {
        return login;
    }
}
