package com.kent.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kent.springwebapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	

}
