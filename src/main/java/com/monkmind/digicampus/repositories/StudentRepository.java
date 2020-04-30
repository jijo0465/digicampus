package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
