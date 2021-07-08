package com.nthieucmc.springjwtmongodb.service;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;

import java.util.List;

public interface SubjectService {

    BaseResponseDTO createSubject(SubjectDTO subjectDTO);

    List<SubjectDTO> getListSubject(Integer pageNo, Integer pageSize, String sortBy);
}
