package com.example.admin.controller;


import com.example.admin.pojo.PageBean;
import com.example.admin.pojo.Result;
import com.example.admin.pojo.comment;
import com.example.admin.service.CommentService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contest_ment")
public class Contest_mentcontroller {


    @Autowired
    private CommentService commentService;

    //用户添加评论
    @PostMapping("/addComment")
    public Result addComment(Integer userid,Integer competitionid,String content) {
        commentService.addComment(userid,competitionid,content);
        return Result.success("评论成功");
    }



    //审核id需要为1,或者2  1代表审核通过  2代表审核不通过
    //管理员审核信息
    @PutMapping("/check")
    public Result checkcomment(Integer commentid, Integer approveid,Integer adminid) {


        //需要修改的地方
        if (approveid != 1 && approveid != 2) {
            return Result.error("审核id错误");
        }
        commentService.checkcomment(commentid,approveid,adminid);
        return Result.success("审核成功");
    }


    //查询评论信息
    @GetMapping("/getcomments")
    public Result<PageBean<comment>> getcomments(Integer pageNum,Integer pageSize,@RequestParam(required = false)Integer checkid) {
        PageBean<comment> pb = commentService.getcomment(pageNum, pageSize, checkid);
        return Result.success(pb);
    }



    //是否需要查询id在数据库里？？？？
    //删除评论
    @DeleteMapping("/delete")
    public Result deletecomment(Integer commentid) {
        try {
            commentService.deletecomment(commentid);
            return Result.success("删除成功");
        }catch (Exception e) {
            return Result.error("删除失败");
        }
    }








}
