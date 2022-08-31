package com.example.testjwt.repo;

import com.example.testjwt.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<AppUser,Long> {
//    AppUser findByUserName(String userName);
AppUser findAppUsersByUserName(String userName);
AppUser findAppUsersByEmail(String email);
}
