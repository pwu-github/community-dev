/**
 * FileName: Question
 * Author: WP
 * Date: 2019/11/16 17:17
 * Description:
 * History:
 **/
package com.wp.community.model;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;

}
