package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.SubjectSchema;


public interface SubjectSchemaService {
    public void save(SubjectSchema subjectSchema);
    public List<SubjectSchema> findAll();
    public void delete(long id);
    

}
