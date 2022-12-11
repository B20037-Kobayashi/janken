package oit.is.z0340.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {
  @Select("SELECT id, user1, user2, user1Hand, user2Hand, isActive from matches;")
  ArrayList<Match> selectAllMatch();

  @Insert("INSERT INTO matches (user1, user2, user1Hand, user2Hand) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand});")
  void insertMatchResult(Match matchResult);

  @Insert("INSERT INTO matches (user1, user2, user1Hand, user2Hand, isActive) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand},#{isActive});")
  void insertMatch(Match matchResult);
}
