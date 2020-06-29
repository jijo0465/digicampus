package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.models.Teacher;

public interface SubjectSchemaService {
    public void save(SubjectSchema subjectSchema);
     public List<SubjectSchema> findAll();

}
