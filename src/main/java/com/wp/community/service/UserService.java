/**
 * FileName: UserService
 * Author: WP
 * Date: 2019/12/22 20:11
 * Description:
 * History:
 **/
package com.wp.community.service;

import com.wp.community.mapper.UserMapper;
import com.wp.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        //如果user为空，插入，否则更新
        if(dbUser == null){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(dbUser);
        }else{
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
        }
    }
}
