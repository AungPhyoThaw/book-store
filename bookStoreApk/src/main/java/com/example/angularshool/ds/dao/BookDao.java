package com.example.angularshool.ds.dao;

import com.example.angularshool.ds.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book,Integer> {

}
