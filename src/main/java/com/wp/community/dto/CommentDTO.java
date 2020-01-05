/**
 * FileName: CommentDTO
 * Author: WP
 * Date: 2020/1/5 14:58
 * Description:
 * History:
 **/
package com.wp.community.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long parent_id;
    private String content;
    private Integer type;
}
