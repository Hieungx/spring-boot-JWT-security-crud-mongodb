package com.nthieucmc.springjwtmongodb.mapper;

import com.nthieucmc.springjwtmongodb.dto.DepartmentDTO;
import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.models.Department;
import com.nthieucmc.springjwtmongodb.models.Subject;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class})
public abstract class DepartmentMapper implements BaseMapper<DepartmentDTO,Department> {
    @Override
//    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID")
    @InheritConfiguration
    @Named("departmentToEntity")
    public abstract Department toEntity(DepartmentDTO dto);

    @Override
//    @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING")
    @InheritConfiguration
    @Named("departmentToDTO")
    public abstract DepartmentDTO toDTO(Department entity);

    @Override
    @IterableMapping(qualifiedByName = "departmentToDTO")
    public abstract List<DepartmentDTO> toListDTO(List<Department> entityList);

    @Override
    @IterableMapping(qualifiedByName = "departmentToEntity")
    public abstract List<Department> toListEntity(List<DepartmentDTO> dtoList);
}
