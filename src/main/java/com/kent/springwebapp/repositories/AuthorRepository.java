package com.kent.springwebapp.repositories;
import org.springframework.data.repository.CrudRepository;

import com.kent.springwebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
	
	

}
