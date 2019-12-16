/**
 * FileName: User
 * Author: WP
 * Date: 2019/11/10 14:51
 * Description:
 * History:
 **/
package com.wp.community.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    //头像
    private String avatarUrl;

}
