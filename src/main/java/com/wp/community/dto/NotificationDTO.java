/**
 * FileName: NotificationDTO
 * Author: WP
 * Date: 2020/2/2 13:30
 * Description:
 * History:
 **/
package com.wp.community.dto;

import com.wp.community.model.User;
import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private Long outerid;
    private String notifierName;
    private String outerTitle;
    private String typeName;
    private Integer type;
}
