package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E, D> {
    E mapDtoToEntity(D dto);
    D mapEntityToDto(E entity);

    void updateEntityFromDto(D dto, @MappingTarget E entity);

}
