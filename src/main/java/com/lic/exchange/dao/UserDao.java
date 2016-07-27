package com.lic.exchange.dao;

import com.lic.exchange.bean.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lichong on 16/7/25.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserEntity findUserById(int id) {
        String sql = "select * from user where id = ?";
        final UserEntity userEntity = new UserEntity();
        jdbcTemplate.query(sql, new Object[]{1}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                userEntity.setPhone(resultSet.getString("phone"));
            }
        });
        return userEntity;
    }

    public void saveOrUpdateUser(int id) {

    }
}
