package com.spring.mongodb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
