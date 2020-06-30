package com.monkmind.digicampus.services;

import java.util.List;
import java.util.Optional;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.SubjectSchema;


public interface SubjectSchemaService {
    public void save(SubjectSchema subjectSchema);
    public List<SubjectSchema> findAll();
    public void delete(long id);
    public List<SubjectSchema> findByGrade(Grade grade);
    public SubjectSchema findById(Long subjectSchema);
    

}
