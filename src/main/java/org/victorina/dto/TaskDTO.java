package org.victorina.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.victorina.attributs.TaskType;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Danil Lyskin at 12:57 16.02.2021
 */

@EqualsAndHashCode(of = {}, callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO extends AbstractDTO {

    @ApiModelProperty(
            value = "Task name",
            dataType = "String",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String name;

    @ApiModelProperty(
            value = "Task descriptions",
            dataType = "String",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String descriptions;

    @ApiModelProperty(
            value = "Task name",
            dataType = "Enum",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private TaskType type;

    @ApiModelProperty(
            value = "Task answers",
            dataType = "Set of task answers"
    )
    private Set<Long> answersId = new HashSet<>();

    @ApiModelProperty(
            value = "Flag of count answers",
            dataType = "Boolean",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean flagOfCountAnswers;

    @ApiModelProperty(
            value = "TaskPreview",
            dataType = "Long",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long taskPreviewId;
}
