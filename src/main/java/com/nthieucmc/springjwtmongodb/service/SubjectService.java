package com.nthieucmc.springjwtmongodb.service;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.dto.response.ListResponseDTO;

import java.util.List;

public interface SubjectService {

    BaseResponseDTO createSubject(SubjectDTO subjectDTO);

    ListResponseDTO<SubjectDTO> getListSubject(List<String> subbjectCode, Integer pageNo, Integer pageSize, String sortBy);

    SubjectDTO getBySubjectCode(String subjectCode);
}
