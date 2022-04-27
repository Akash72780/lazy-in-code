package com.dummy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dummy.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findBookId(String book_cd);

}
