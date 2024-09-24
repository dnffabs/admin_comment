package com.example.admin.service.impl;

import com.example.admin.mapper.CommentMapper;
import com.example.admin.pojo.PageBean;
import com.example.admin.pojo.comment;
import com.example.admin.service.CommentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Integer userid, Integer competitionid, String content) {
        commentMapper.addComment(userid, competitionid,content);

    }

    @Override
    public void checkcomment(Integer commentid, Integer approveid,Integer admin) {
        commentMapper.checkcomment(commentid,approveid,admin);
    }

    @Override
    public PageBean<comment> getcomment(Integer pageNum, Integer pageSize, Integer checkid) {
        //创建Pagebean对象
        PageBean<comment> pb = new PageBean<>();
        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        //查询所有评论信息
        List<comment> comments = commentMapper.getcomments(checkid);
        //获取分页信息
        Page<comment> c = (Page<comment>) comments;
        //把数据填充
        pb.setTotal(c.getTotal());
        pb.setItems(c.getResult());
        return pb;
    }

    @Override
    public void deletecomment(Integer commentid) {
        commentMapper.deletecomment(commentid);
    }


}
