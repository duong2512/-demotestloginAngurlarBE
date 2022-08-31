package com.example.testjwt.repo;

import com.example.testjwt.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role,Long> {
}
