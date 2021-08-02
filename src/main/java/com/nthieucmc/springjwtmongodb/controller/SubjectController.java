package com.nthieucmc.springjwtmongodb.controller;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;

import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.dto.response.ListResponseDTO;
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
    public ResponseEntity<ListResponseDTO<SubjectDTO>> getAllSubject(
            @RequestParam(required = false, defaultValue = "") List<String> subjectCode,
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, defaultValue = "-1") String sortBy) {
        ListResponseDTO<SubjectDTO> list = subjectService.getListSubject(subjectCode,pageNo, pageSize, sortBy);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponseDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {
        BaseResponseDTO response = subjectService.createSubject(subjectDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-by-code")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<SubjectDTO> getBySubjectCode(@RequestParam String subjectCode) {
        SubjectDTO subjectDTO = subjectService.getBySubjectCode(subjectCode);
        return ResponseEntity.ok(subjectDTO);
    }

    @DeleteMapping("/delete-by-code")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponseDTO> deleteSubject(@RequestParam String subjectCode) {
        BaseResponseDTO baseResponseDTO = subjectService.deleteSubject(subjectCode);
        return ResponseEntity.ok(baseResponseDTO);
    }
}
