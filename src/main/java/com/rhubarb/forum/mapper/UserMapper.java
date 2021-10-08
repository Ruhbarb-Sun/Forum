package com.rhubarb.forum.mapper;

import com.rhubarb.forum.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: sunxun
 * @date: 10/7/21 2:01 PM
 * @description:
 */

@Repository
@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id, name, token, gmt_create, gmt_modified, avatar_url) " +
            "values (#{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified}, #{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);
}
