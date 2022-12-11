package oit.is.z0340.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.Insert;
// import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

  @Select("SELECT id,userName from users;")
  ArrayList<User> selectAllUserName();

  @Select("SELECT id,userName  from users where id = #{id};")
  User selectById(int id);

  @Select("SELECT id,userName from users where userName = #{userName};")
  User getIdByName(String userName);

}
