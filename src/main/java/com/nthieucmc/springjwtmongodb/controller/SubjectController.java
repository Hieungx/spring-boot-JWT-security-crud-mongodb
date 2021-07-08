package com.nthieucmc.springjwtmongodb.controller;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;

import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Resource
    SubjectService subjectService;

    @GetMapping("/get-all-subject")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<SubjectDTO>> getAllSubject(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "subjectCode") String sortBy) {
        List<SubjectDTO> list = subjectService.getListSubject(pageNo, pageSize, sortBy);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create-subject")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponseDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {
        BaseResponseDTO response = subjectService.createSubject(subjectDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-by-subjectcode")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<SubjectDTO> getBySubjectCode(@RequestParam String subjectCode) {
        SubjectDTO subjectDTO = subjectService.getBySubjectCode(subjectCode);
        return ResponseEntity.ok(subjectDTO);
    }
}
