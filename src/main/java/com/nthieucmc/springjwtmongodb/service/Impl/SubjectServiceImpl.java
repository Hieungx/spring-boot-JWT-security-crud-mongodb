package com.nthieucmc.springjwtmongodb.service.Impl;


import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;

import com.nthieucmc.springjwtmongodb.mapper.SubjectMapper;
import com.nthieucmc.springjwtmongodb.models.Subject;
import com.nthieucmc.springjwtmongodb.repository.SubjectRepository;
import com.nthieucmc.springjwtmongodb.service.SubjectService;
import com.nthieucmc.springjwtmongodb.validation.ValidationResult;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    SubjectRepository subjectRepository;

    @Resource
    SubjectMapper subjectMapper;

    @Override
    public List<SubjectDTO> getListSubject(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<Subject> pageResult = subjectRepository.findAll(paging);

        if (pageResult.hasContent()){
            return subjectMapper.toListDTO(pageResult.getContent());
        } else {
            return new ArrayList<SubjectDTO>();
        }
    }


    @Override
    public BaseResponseDTO createSubject(SubjectDTO subjectDTO) {
        subjectRepository.save(subjectMapper.toEntity(subjectDTO));
        return new BaseResponseDTO();
    }

    private ValidationResult validateSubjectExisted(String subjectCode) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setSuccessful(true);
        if(ObjectUtils.isEmpty(subjectRepository.findBySubjectCode(subjectCode))){
            validationResult.setSuccessful(false);
        }
        return validationResult;
    }
}
