/**
 * FileName: FileDTO
 * Author: WP
 * Date: 2020/2/3 9:56
 * Description:
 * History:
 **/
package com.wp.community.dto;

import lombok.Data;

@Data
public class FileDTO {
    private int success;
    private String message;
    private String url;
}
