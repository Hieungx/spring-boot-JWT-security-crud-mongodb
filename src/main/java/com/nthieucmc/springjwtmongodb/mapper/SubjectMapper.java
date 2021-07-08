package com.nthieucmc.springjwtmongodb.mapper;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.dto.UserDTO;
import com.nthieucmc.springjwtmongodb.models.Subject;
import com.nthieucmc.springjwtmongodb.models.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class})

public abstract class SubjectMapper implements BaseMapper<SubjectDTO, Subject> {
    @Override
    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID")
    @InheritConfiguration
    @Named("subjectToEntity")
    public abstract Subject toEntity(SubjectDTO dto);

    @Override
    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING")
    @InheritConfiguration
    @Named("subjectToDTO")
    public abstract SubjectDTO toDTO(Subject entity);

    @Override
    @IterableMapping(qualifiedByName = "userToDTO")
    public abstract List<SubjectDTO> toListDTO(List<Subject> entityList);

    @Override
    @IterableMapping(qualifiedByName = "userToEntity")
    public abstract List<Subject> toListEntity(List<SubjectDTO> dtoList);
}
