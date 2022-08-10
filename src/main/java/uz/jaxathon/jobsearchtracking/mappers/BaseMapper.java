package uz.jaxathon.jobsearchtracking.mappers;

public interface BaseMapper<E, D> {
    E mapDtoToEntity(D dto);
    D mapEntityToDto(E entity);
}
