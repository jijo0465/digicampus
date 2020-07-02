package com.monkmind.digicampus.services.service_impl;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.repositories.SubjectSchemaRepository;
import com.monkmind.digicampus.services.SubjectSchemaService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

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
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		subjectSchemaRepository.deleteById(id);
	}

	@Override
	public List<SubjectSchema> findByGrade(Grade grade){
    	 return subjectSchemaRepository.findByGrade(grade);
	}

	@Override
	public SubjectSchema findById(Long subjectSchema)
	{
    	Optional<SubjectSchema> schema= subjectSchemaRepository.findById(subjectSchema);
    	return schema.get();
	}
	@Override
	public List<SubjectSchema> listAll() {
		// TODO Auto-generated method stub
		return subjectSchemaRepository.findAll();
	}

}
