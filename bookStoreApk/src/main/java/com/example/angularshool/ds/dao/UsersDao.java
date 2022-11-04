package com.example.angularshool.ds.dao;

import com.example.angularshool.ds.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {
}
