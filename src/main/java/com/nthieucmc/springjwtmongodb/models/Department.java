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
@Document(collection = "department")
public class Department {
    @Id
    private ObjectId id;
    @Field(DBKey.DepartmentKey.DEPARTMENT_CODE)
    private String departmentCode;
    @Field(DBKey.DepartmentKey.DEPARTMENT_NAME)
    private String departmentName;
    @Field(DBKey.DepartmentKey.DEPARTMENT_LEAD)
    private String departmentLead;
}
