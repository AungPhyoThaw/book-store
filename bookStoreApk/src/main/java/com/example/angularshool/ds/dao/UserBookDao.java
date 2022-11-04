package com.example.angularshool.ds.dao;

import com.example.angularshool.ds.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookDao extends JpaRepository<UserBook,Integer> {
    @Query("select u from UserBook u where u.users.id=:userid")
    UserBook findUserBookByUserId(@Param("userid")int userid);
}
