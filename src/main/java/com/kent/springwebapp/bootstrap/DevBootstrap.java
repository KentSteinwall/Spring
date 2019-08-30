package com.kent.springwebapp.bootstrap;

import com.kent.springwebapp.model.Author;
import com.kent.springwebapp.model.Book;
import com.kent.springwebapp.model.Publisher;
import com.kent.springwebapp.repositories.AuthorRepository;
import com.kent.springwebapp.repositories.BookRepository;
import com.kent.springwebapp.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
		
	}

	private void initData() {
		
		Publisher publisher=new Publisher();
		publisher.setName("Kamal");
		
		publisherRepository.save(publisher);
		
		Author kent =new Author("Kent","Steinwall");
		Book book=new Book("Domain Driven Design","1234",publisher);
		kent.getBooks().add(book);
		book.getAuthors().add(kent);
		
		authorRepository.save(kent);
		bookRepository.save(book);
		
		Author dinith =new Author("Dinith","Silva");
		Book book1=new Book("Domain Design","1234",publisher);
		dinith.getBooks().add(book1);
		
		authorRepository.save(dinith);
		bookRepository.save(book1);
		
	}

}
