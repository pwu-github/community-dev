/**
 * FileName: NotificationController
 * Author: WP
 * Date: 2020/2/2 15:39
 * Description:
 * History:
 **/
package com.wp.community.controller;

import com.wp.community.dto.NotificationDTO;
import com.wp.community.enums.NotificationTypeEnum;
import com.wp.community.model.User;
import com.wp.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            return "redirect:/";
        }
        NotificationDTO notificationDTO = notificationService.read(id,user);
        if(NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()
                || NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()){
            return "redirect:/question/"+notificationDTO.getOuterid();
        }else{
            return "profile";
        }
    }

}
