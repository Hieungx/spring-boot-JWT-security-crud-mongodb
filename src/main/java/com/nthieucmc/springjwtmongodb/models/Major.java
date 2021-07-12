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
@Document(collection = "major")
public class Major {
    @Id
    private ObjectId id;
    @Field(DBKey.MajorKey.MAJOR_CODE)
    private String majorCode;
    @Field(DBKey.MajorKey.MAJOR_NAME)
    private String majorName;
    @Field(DBKey.DepartmentKey.DEPARTMENT_CODE)
    private List<Department> departmentCodes;
}
