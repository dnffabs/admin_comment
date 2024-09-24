package com.example.admin.mapper;


import com.example.admin.pojo.comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into competition_comment (user_id,competition_id,comment_text) values(#{userid},#{competitionid},#{content})")
    void addComment(Integer userid, Integer competitionid, String content);

    @Update("update competition_comment set is_approved=#{approveid},approved_by=#{admin} where comment_id=#{commentid}")
    void checkcomment(Integer commentid, Integer approveid,Integer admin);

    List<comment> getcomments(Integer checkid);

    @Delete("delete from competition_comment where comment_id=#{commentid}")
    void deletecomment(Integer commentid);
}
