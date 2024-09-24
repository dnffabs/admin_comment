package com.example.admin.pojo;


import lombok.Data;

import java.time.LocalDateTime;


//CREATE TABLE Competition_Comment (
//        comment_id INT PRIMARY KEY AUTO_INCREMENT,      -- 自增ID，主键
//        user_id INT NOT NULL,                           -- 用户ID，外键，不能为空
//                competition_id INT NOT NULL,                    -- 竞赛ID，外键，不能为空
//                comment_text TEXT NOT NULL,                     -- 评论内容，不能为空
//                created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 创建时间，默认为当前时间
//                is_approved BOOLEAN NOT NULL DEFAULT 0,         -- 是否审核，默认0（未审核），不能为空
//                approved_by INT,                                -- 审核人ID，可为空
//);
@Data
public class comment {
    private int commentid;//主键ID
    private int userid;//用户ID
    private int competitionid;//竞赛ID
    private String commenttext;//评论内容
    private LocalDateTime createdat;//创建时间
    private int isapproved;//审核id
    private int approved_by;//审核人ID
}
