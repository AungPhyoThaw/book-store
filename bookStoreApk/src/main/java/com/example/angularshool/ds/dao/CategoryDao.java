package com.example.angularshool.ds.dao;

import com.example.angularshool.ds.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,Integer> {

}
