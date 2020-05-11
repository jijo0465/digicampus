package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByLoginId(String id);
}
