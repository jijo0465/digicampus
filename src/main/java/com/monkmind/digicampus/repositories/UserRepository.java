package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByLoginId(String id);
    
    
}
