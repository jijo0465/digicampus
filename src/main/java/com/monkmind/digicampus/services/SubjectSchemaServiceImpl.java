package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.repositories.SubjectSchemaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectSchemaServiceImpl implements SubjectSchemaService{
    private final SubjectSchemaRepository subjectSchemaRepository;
    public void save(SubjectSchema subjectSchema){
        subjectSchemaRepository.save(subjectSchema);
    }
	@Override
	public List<SubjectSchema> findAll() {
		// TODO Auto-generated method stub
		return subjectSchemaRepository.findAll();
	}

}
