package com.nthieucmc.springjwtmongodb.service.Impl;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.mapper.SubjectMapper;
import com.nthieucmc.springjwtmongodb.models.Subject;
import com.nthieucmc.springjwtmongodb.repository.SubjectRepository;
import com.nthieucmc.springjwtmongodb.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    SubjectRepository subjectRepository;

    @Resource
    SubjectMapper subjectMapper;

    @Override
    public List<SubjectDTO> getListSubject() {
        List<Subject> subjectList = subjectRepository.findAll();
        List<SubjectDTO> subjectDTOS = subjectMapper.toListDTO(subjectList);
        return subjectDTOS;
    }
}
