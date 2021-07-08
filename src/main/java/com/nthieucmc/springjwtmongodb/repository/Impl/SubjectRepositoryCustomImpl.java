package com.nthieucmc.springjwtmongodb.repository.Impl;

import com.nthieucmc.springjwtmongodb.models.Subject;
import com.nthieucmc.springjwtmongodb.repository.SubjectRepositoryCustom;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

public class SubjectRepositoryCustomImpl implements SubjectRepositoryCustom {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public Subject findBySubjectCode(String subjectCode) {
        Query query = new Query();
        query.addCriteria(Criteria.where("subject_code").is(subjectCode));
        Subject subject = mongoTemplate.findOne(query,Subject.class);
        return subject;
    }
}
