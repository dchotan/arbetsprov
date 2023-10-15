package com.arbetsprov.stugbokning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arbetsprov.stugbokning.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
