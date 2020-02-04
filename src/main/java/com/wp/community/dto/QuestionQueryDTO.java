/**
 * FileName: QuestionQueryDTO
 * Author: WP
 * Date: 2020/2/4 10:01
 * Description:
 * History:
 **/
package com.wp.community.dto;

import lombok.Data;

@Data
public class QuestionQueryDTO {

    private String search;
    private Integer page;
    private Integer size;

}
