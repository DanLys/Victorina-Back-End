package org.victorina.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Danil Lyskin at 12:59 16.02.2021
 */

@Data
public class AbstractDTO {

    @ApiModelProperty(
            hidden = true
    )
    private Long id;
}
