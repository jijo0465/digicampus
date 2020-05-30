package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.models.ExamTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTestRepository extends CrudRepository<ExamTest, Long> {
}
