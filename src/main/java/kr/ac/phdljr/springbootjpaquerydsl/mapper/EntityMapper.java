package kr.ac.phdljr.springbootjpaquerydsl.mapper;

public interface EntityMapper<D, E> {
    E toEntity(D dto);
    D toDto(E Entity);
}
