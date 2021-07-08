package com.nthieucmc.springjwtmongodb.controllers;

import com.nthieucmc.springjwtmongodb.dto.SubjectDTO;
import com.nthieucmc.springjwtmongodb.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Resource
    SubjectService subjectService;

    @GetMapping("/get-all-subject")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<SubjectDTO>> getAllSubject() {
        List<SubjectDTO> list = subjectService.getListSubject();
        return ResponseEntity.ok(list);
    }
}
