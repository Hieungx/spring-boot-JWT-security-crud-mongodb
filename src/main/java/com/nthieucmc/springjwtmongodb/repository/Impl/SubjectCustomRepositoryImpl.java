package com.nthieucmc.springjwtmongodb.repository.Impl;

import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.UpdateResult;
import com.nthieucmc.springjwtmongodb.constant.DBKey;
import com.nthieucmc.springjwtmongodb.models.Subject;
import com.nthieucmc.springjwtmongodb.repository.SubjectCustomRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RequiredArgsConstructor
public class SubjectCustomRepositoryImpl implements SubjectCustomRepository {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public Subject findBySubjectCode(String subjectCode) {
        Query query = new Query();
        query.addCriteria(Criteria.where("subject_code").is(subjectCode));
        Subject subject = mongoTemplate.findOne(query, Subject.class);
        return subject;
    }

    @Override
    public List<Subject> querySubjectByFilter(List<String> subjectCode) {
        Criteria query = new Criteria();
        if (subjectCode != null && !subjectCode.isEmpty()) {
            query.and(DBKey.SubjectKey.SUBJECT_CODE).in(subjectCode);
        }
        MatchOperation matchOperation = match(query);
        Aggregation aggregation = newAggregation(matchOperation);

        AggregationResults<Subject> aggregationResults = mongoTemplate.aggregate(aggregation, DBKey.SUBJECT_COLLECTION, Subject.class);
        List<Subject> result = aggregationResults.getMappedResults();
        return result;
    }

    @Override
    public List<Subject> getAllSubjectWithFilterPageable(List<ObjectId> listSubjectId, int page, int size, String direction, long totalNumberElement) {
        Criteria query = new Criteria();
        //Search Subject
        if (listSubjectId != null) {
            query.and(DBKey.SubjectKey._ID).in(listSubjectId);
        }
        MatchOperation matchOperation = match(query);

        //caculate if total number > size or not
        long skipNumber;
        if (totalNumberElement <= size) {
            skipNumber = 0;
        } else {
            skipNumber = (page - 1) * size;
        }
        SkipOperation skipOperation = skip(skipNumber);

        LimitOperation limitOperation = limit(size);

        Sort.Direction direction1 = Sort.Direction.ASC;
        if ("-1".equalsIgnoreCase(direction)) {
            direction1 = Sort.Direction.DESC;
        }
        SortOperation sortOperation = sort(direction1, DBKey.SubjectKey.SUBJECT_NAME);

        Aggregation aggregation = newAggregation(
                matchOperation,
                skipOperation,
                limitOperation,
                sortOperation
        );

        AggregationResults<Subject> aggregationResults = mongoTemplate.aggregate(aggregation, DBKey.SUBJECT_COLLECTION, Subject.class);

        List<Subject> result = aggregationResults.getMappedResults();
        return result;
    }
}
