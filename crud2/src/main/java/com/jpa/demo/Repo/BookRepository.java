package com.jpa.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
