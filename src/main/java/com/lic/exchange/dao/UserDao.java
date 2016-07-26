package com.lic.exchange.dao;

import com.lic.exchange.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lichong on 16/7/25.
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    @Modifying
    @Transactional
    @Query("update UserEntity set name=:qName where id=:qId")
    public void updateUser(@Param("qName") String name, @Param("qId") int id);
}
