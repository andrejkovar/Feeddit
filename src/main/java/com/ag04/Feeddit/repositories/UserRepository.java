package com.ag04.Feeddit.repositories;

import com.ag04.Feeddit.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
}
