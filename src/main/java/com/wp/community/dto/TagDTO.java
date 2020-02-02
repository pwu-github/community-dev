/**
 * FileName: TagDTO
 * Author: WP
 * Date: 2020/2/1 13:38
 * Description:
 * History:
 **/
package com.wp.community.dto;

import lombok.Data;

import java.util.List;

@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
