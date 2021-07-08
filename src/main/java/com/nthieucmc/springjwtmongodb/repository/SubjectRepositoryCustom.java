package com.nthieucmc.springjwtmongodb.repository;

import com.nthieucmc.springjwtmongodb.models.Subject;

public interface SubjectRepositoryCustom {
    Subject findBySubjectCode(String subjectCode);
}
