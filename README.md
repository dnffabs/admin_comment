# admin_comment
**管理员可以审核评论，分页查询评论，以及删除评论**


*创建数据库表，没有关联外表*
```SQL
CREATE TABLE Competition_Comment (
                                     comment_id INT PRIMARY KEY AUTO_INCREMENT,      -- 自增ID，主键
                                     user_id INT NOT NULL,                           -- 用户ID，外键，不能为空
                                     competition_id INT NOT NULL,                    -- 竞赛ID，外键，不能为空
                                     comment_text TEXT NOT NULL,                     -- 评论内容，不能为空
                                     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 创建时间，默认为当前时间
                                     is_approved INT NOT NULL DEFAULT 0,         -- 是否审核，默认0（未审核），不能为空
                                     approved_by INT                            -- 审核人ID，可为空
);
```

*创建java数据类 comment*


```java

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
``` 
评论在插入的时候默认审核id均为0，表示还未审核

**项目结构**：


![image](https://github.com/user-attachments/assets/63021e77-e32d-4ad0-91d1-dad37f999f25)



# addComment
#添加评论(测试的时候需要)
参数名称| 参数类型 |参数是否必需|参数描述
 ---- | ----- | ------  |---------
userid  | Integer| Y| 用户id
competitionid | Integer |Y| 竞赛id
content | String | Y |评论内容

返回数据：
Result.success("评论成功")


# checkcomment
管理员检查评论
参数名称| 参数类型 |参数是否必需|参数描述
 ---- | ----- | ------  |---------
commentid  | Integer| Y| 评论的id
approveid | Integer |Y| 审核的结果，1表示审核通过，2表示审核不通过
adminid | Integer | Y |审核人的id

返回数据：
返回数据类型|内容
----|-----|
成功json|Result.success("审核成功")
失败json|Result.error("审核id错误")，当传入审核结果不正确时

# getcomments
管理员获取评论信息
参数名称| 参数类型 |参数是否必需|参数描述
 ---- | ----- | ------  |---------
pageNum | Integer| Y| 总页数
pageSize | Integer |Y| 每页的数据数量
checkid| Integer | N |筛选信息(checkid中，不传返回全部，传1表示审核通过，传2表示审核未通过，传0表示未审核)

返回数据：
返回数据类型|内容
----|-----|
PageBean<comment>|评论信息



# deletecomment
管理员删除评论
参数名称| 参数类型 |参数是否必需|参数描述
 ---- | ----- | ------  |---------
commentid  | Integer| Y| 评论的id
