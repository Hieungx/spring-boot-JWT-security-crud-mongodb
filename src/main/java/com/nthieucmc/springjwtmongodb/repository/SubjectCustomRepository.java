package com.nthieucmc.springjwtmongodb.repository;

import com.nthieucmc.springjwtmongodb.models.Subject;
import org.bson.types.ObjectId;

import java.util.List;

public interface SubjectCustomRepository {
    Subject findBySubjectCode(String subjectCode);

    List<Subject> querySubjectByFilter(List<String> subjectCode);

    List<Subject> getAllSubjectWithFilterPageable(List<ObjectId> listSubjectId, int page, int size, String direction, long totalNumberElement);
}
