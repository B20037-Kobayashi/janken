package oit.is.z0340.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper {
  @Select("SELECT id, user1, user2, isActive from matchinfo where isActive = true;")
  ArrayList<MatchInfo> selectActiveMatch();

  @Insert("INSERT INTO matchinfo (user1, user2, user1Hand, isActive)VALUES(#{user1},#{user2},#{user1Hand},#{isActive});")
  void insertMatchInfo(MatchInfo matchinfo);

  @Select("SELECT id, user1, user2, user1Hand, isActive from matchinfo where isActive = true and id = #{id};")
  MatchInfo selfCheckActive(int id);
}
