package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.repositories.SubjectSchemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectSchemaServiceImpl implements SubjectSchemaService{
    private final SubjectSchemaRepository subjectSchemaRepository;
    public void save(SubjectSchema subjectSchema){
        subjectSchemaRepository.save(subjectSchema);
    }

}
