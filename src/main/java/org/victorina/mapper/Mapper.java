package org.victorina.mapper;

import org.victorina.data_entities.AbstractEntity;
import org.victorina.dto.AbstractDTO;

/**
 * Created by Danil Lyskin at 20:52 08.03.2021
 */
public interface Mapper<E extends AbstractEntity, D extends AbstractDTO> {
    E toEntity(D dto);

    D toDto(E entity);
}
