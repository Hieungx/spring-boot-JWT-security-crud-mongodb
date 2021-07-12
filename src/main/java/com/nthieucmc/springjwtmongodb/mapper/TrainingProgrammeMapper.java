package com.nthieucmc.springjwtmongodb.mapper;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.dto.TrainingProgrammeDTO;
import com.nthieucmc.springjwtmongodb.models.Subject;
import com.nthieucmc.springjwtmongodb.models.TrainingProgramme;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class})
public abstract class TrainingProgrammeMapper implements BaseMapper<TrainingProgrammeDTO, TrainingProgramme>{
    @Override
//    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID")
    @InheritConfiguration
    @Named("trainingProgrammeToEntity")
    public abstract TrainingProgramme toEntity(TrainingProgrammeDTO dto);

    @Override
//    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING")
    @InheritConfiguration
    @Named("trainingProgrammeToDTO")
    public abstract TrainingProgrammeDTO toDTO(TrainingProgramme entity);

    @Override
    @IterableMapping(qualifiedByName = "trainingProgrammeToDTO")
    public abstract List<TrainingProgrammeDTO> toListDTO(List<TrainingProgramme> entityList);

    @Override
    @IterableMapping(qualifiedByName = "trainingProgrammeToEntity")
    public abstract List<TrainingProgramme> toListEntity(List<TrainingProgrammeDTO> dtoList);
}
