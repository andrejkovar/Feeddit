package com.ag04.Feeddit.repositories;

import com.ag04.Feeddit.entities.LoggedUser;
import org.springframework.data.repository.CrudRepository;

public interface LoggedUserRepository extends CrudRepository<LoggedUser, String> {
}
