package com.nthieucmc.springjwtmongodb.models;

import com.nthieucmc.springjwtmongodb.constant.DBKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "subject")
public class Subject {
    @Id
    private ObjectId id;
    @Field(DBKey.SubjectKey.SUBJECT_CODE)
    private String subjectCode;
    @Field(DBKey.SubjectKey.SUBJECT_NAME)
    private String subjectName;
    @Field(DBKey.SubjectKey.CREDIT)
    private String credit;
}
