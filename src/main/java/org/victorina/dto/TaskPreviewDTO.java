package org.victorina.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Danil Lyskin at 22:09 08.03.2021
 */

@EqualsAndHashCode(of = {}, callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskPreviewDTO extends AbstractDTO {

    @ApiModelProperty(
            value = "Task name",
            dataType = "String",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String name;

    @ApiModelProperty(
            value = "Task hard level",
            dataType = "Long",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long hardLevel;

    @ApiModelProperty(
            value = "Task questions",
            dataType = "Set of questions"
    )
    @JsonIgnore
    private Set<Long> tasks = new HashSet<>();

    @ApiModelProperty(
            value = "Count of tasks",
            dataType = "Long"
    )
    private Long countOfTasks;
}
