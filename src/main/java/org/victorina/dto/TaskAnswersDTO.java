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
            dataType = "String"
    )
    private String answer;

    @ApiModelProperty(
            value = "Flag for true/false answer",
            dataType = "Boolean"
    )
    private Boolean isTrue;

    @ApiModelProperty(
            value = "Task",
            dataType = "Long"
    )
    private Long taskId;
}
