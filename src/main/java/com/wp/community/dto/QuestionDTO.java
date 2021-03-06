/**
 * FileName: QuestionDTO
 * Author: WP
 * Date: 2019/12/15 12:40
 * Description:
 * History:
 **/
package com.wp.community.dto;

import com.wp.community.model.User;
import lombok.Data;
/*
* @Author wupeng
* @Description //TODO
* @Date 12:58 2019/12/15
* @Param
* @return
* DTO 是用于页面传递数据的对象
* 抽象QuestionDTO是为了在首页展示问题列表时，得到user的头像，属性在Question属性的基础上
* 加上了user属性，目的是通过creator属性查出user对象
* QuestionDTO包含了Question和User的属性
**/

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    //user的id
    private Long creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private User user;
}
