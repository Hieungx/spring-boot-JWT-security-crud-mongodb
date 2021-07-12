package com.nthieucmc.springjwtmongodb.mapper;

import com.nthieucmc.springjwtmongodb.dto.MajorDTO;
import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.models.Major;
import com.nthieucmc.springjwtmongodb.models.Subject;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class})
public abstract class MajorMapper implements BaseMapper<MajorDTO, Major>{
    @Override
//    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID")
    @InheritConfiguration
    @Named("majorToEntity")
    public abstract Major toEntity(MajorDTO dto);

    @Override
//    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING")
    @InheritConfiguration
    @Named("majorToDTO")
    public abstract MajorDTO toDTO(Major entity);

    @Override
    @IterableMapping(qualifiedByName = "majorToDTO")
    public abstract List<MajorDTO> toListDTO(List<Major> entityList);

    @Override
    @IterableMapping(qualifiedByName = "majorToEntity")
    public abstract List<Major> toListEntity(List<MajorDTO> dtoList);
}
