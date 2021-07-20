package com.nthieucmc.springjwtmongodb.repository;

import com.nthieucmc.springjwtmongodb.models.Subject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, ObjectId>,SubjectCustomRepository {
}
