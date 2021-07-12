package com.nthieucmc.springjwtmongodb.constant;

public class DBKey {
    public static final String SUBJECT_COLLECTION = "subject";
    public static class SubjectKey {
        public static final String _ID = "_id";
        public static final String SUBJECT_CODE = "subject_code";
        public static final String SUBJECT_NAME = "subject_name";
        public static final String CREDIT = "credit"; //So tin chi
    }

    public static final String DEPARTMENT_COLLECTION = "department";
    public static class DepartmentKey {
        public static final String _ID = "_id";
        public static final String DEPARTMENT_CODE = "department_code";
        public static final String DEPARTMENT_NAME = "department_name";
        public static final String DEPARTMENT_LEAD = "department_lead";
    }

    public static final String MAJOR_COLLECTION = "collection";
    public static class MajorKey {
        public static final String _ID = "_id";
        public static final String MAJOR_CODE = "major_code";
        public static final String MAJOR_NAME = "major_name";
    }
}
