package com.nthieucmc.springjwtmongodb.models;

import com.nthieucmc.springjwtmongodb.constant.DBKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "training_programme")
public class TrainingProgramme {
    @Id
    private ObjectId id;
    @Field(DBKey.TrainingProgrammeKey.TRAINING_PROGRAMME_CODE)
    private String trainingProgrammeCode;
    @Field(DBKey.TrainingProgrammeKey.TRAINING_PROGRAMME_NAME)
    private String trainingProgrammeName;
    @Field(DBKey.MajorKey.MAJOR_CODE)
    private List<String> majorCodes;
}
