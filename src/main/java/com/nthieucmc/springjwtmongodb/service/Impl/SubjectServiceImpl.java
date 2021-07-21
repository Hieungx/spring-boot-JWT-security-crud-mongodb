package com.nthieucmc.springjwtmongodb.service.Impl;


import com.nthieucmc.springjwtmongodb.constant.ErrorCode;
import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;

import com.nthieucmc.springjwtmongodb.dto.response.ListResponseDTO;
import com.nthieucmc.springjwtmongodb.dto.response.PageDTO;
import com.nthieucmc.springjwtmongodb.exception.CustomException;
import com.nthieucmc.springjwtmongodb.mapper.SubjectMapper;
import com.nthieucmc.springjwtmongodb.models.Subject;
import com.nthieucmc.springjwtmongodb.repository.SubjectRepository;
import com.nthieucmc.springjwtmongodb.service.SubjectService;
import com.nthieucmc.springjwtmongodb.utils.PageUtils;
import com.nthieucmc.springjwtmongodb.validation.ValidationResult;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    SubjectRepository subjectRepository;

    @Resource
    SubjectMapper subjectMapper;

    @Override
    public ListResponseDTO<SubjectDTO> getListSubject(List<String> subjectCode, Integer pageNo, Integer pageSize, String sortBy) {
        //TODO : validate validate(direction,page,size)
//        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
//
//        Page<Subject> pageResult = subjectRepository.findAll(paging);
//
//        if (pageResult.hasContent()){
//            return subjectMapper.toListDTO(pageResult.getContent());
//        } else {
//            return new ArrayList<SubjectDTO>();
//        }
        List<ObjectId> listSubjectId = new ArrayList<>();
        if (!CollectionUtils.isEmpty(subjectCode)) {
            List<Subject> list = subjectRepository.querySubjectByFilter(subjectCode);
            listSubjectId = list.stream().map(ele -> ele.getId()).collect(Collectors.toList());
        } else {
            List<Subject> list = subjectRepository.findAll();
            listSubjectId = list.stream().map(ele -> ele.getId()).collect(Collectors.toList());
        }
        long totalNumberElement = listSubjectId.size();

        List<Subject> subjects = subjectRepository.getAllSubjectWithFilterPageable(listSubjectId, pageNo, pageSize, sortBy, totalNumberElement);
        List<SubjectDTO> subjectDTOS = subjectMapper.toListDTO(subjects);

        PageDTO pageDTO = PageUtils.calculatePage(pageSize, pageNo, totalNumberElement);
        return new ListResponseDTO<>(subjectDTOS,pageDTO);
    }

    @Override
    public SubjectDTO getBySubjectCode(String subjectCode) {
        Subject subject = subjectRepository.findBySubjectCode(subjectCode);
        return subjectMapper.toDTO(subject);
    }

    @Override
    public BaseResponseDTO deleteSubject(String subjectCode) {
        ValidationResult validationResult = validateSubjectExisted(subjectCode);
        if (!validationResult.isSuccessful()) {
            throw new CustomException(validationResult.getCode(),validationResult.getMessage());
        }
        BaseResponseDTO baseResponseDTO = subjectRepository.deleteSubject(subjectCode);
        return baseResponseDTO;
    }


    @Override
    public BaseResponseDTO createSubject(SubjectDTO subjectDTO) {
        subjectRepository.save(subjectMapper.toEntity(subjectDTO));
        return new BaseResponseDTO();
    }

    private ValidationResult validateSubjectExisted(String subjectCode) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setSuccessful(true);
        if (ObjectUtils.isEmpty(subjectRepository.findBySubjectCode(subjectCode))) {
            validationResult.setSuccessful(false);
            validationResult.setMessage("Subject not found");
        }
        return validationResult;
    }
}
