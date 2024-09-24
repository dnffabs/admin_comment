package com.example.admin.service;

import com.example.admin.pojo.PageBean;
import com.example.admin.pojo.comment;

import java.util.List;

public interface CommentService {


    void addComment(Integer userid, Integer competitionid, String content);

    void checkcomment(Integer commentid, Integer approveid,Integer admin);

    //条件分页列表查询
    PageBean<comment> getcomment(Integer pageNum, Integer pageSize, Integer checkid);


    void deletecomment(Integer commentid);
}
