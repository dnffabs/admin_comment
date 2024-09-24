# admin_comment
管理员可以审核评论，分页查询评论，以及删除评论



创建数据库表，没有关联外表
CREATE TABLE Competition_Comment (
                                     comment_id INT PRIMARY KEY AUTO_INCREMENT,      -- 自增ID，主键
                                     user_id INT NOT NULL,                           -- 用户ID，外键，不能为空
                                     competition_id INT NOT NULL,                    -- 竞赛ID，外键，不能为空
                                     comment_text TEXT NOT NULL,                     -- 评论内容，不能为空
                                     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 创建时间，默认为当前时间
                                     is_approved INT NOT NULL DEFAULT 0,         -- 是否审核，默认0（未审核），不能为空
                                     approved_by INT                            -- 审核人ID，可为空
);



评论初始化全为0
checkcomment
管理员检查评论

