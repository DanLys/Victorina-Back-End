package org.victorina.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * Created by Danil Lyskin at 13:04 16.02.2021
 */

@EqualsAndHashCode(of = {}, callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskAnswersDTO extends AbstractDTO {

    @ApiModelProperty(
            value = "Task answer",
            dataType = "String",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String answer;

    @ApiModelProperty(
            value = "Flag for true/false answer",
            dataType = "Boolean",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean isTrue;

    @ApiModelProperty(
            value = "Task",
            dataType = "Long",
            accessMode = ApiModelProperty.AccessMode.READ_ONLY
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long taskId;
}
