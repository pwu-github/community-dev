/**
 * FileName: CommentController
 * Author: WP
 * Date: 2020/1/5 14:59
 * Description:
 * History:
 **/
package com.wp.community.controller;

import com.wp.community.dto.CommentCreateDTO;
import com.wp.community.dto.ResultDTO;
import com.wp.community.exception.CustomizeErrorCode;
import com.wp.community.model.Comment;
import com.wp.community.model.User;
import com.wp.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }
        Comment comment = new Comment();
        comment.setContent(commentCreateDTO.getContent());
        comment.setParentId(commentCreateDTO.getParent_id());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        Map<Object,Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("message","成功");
        return objectObjectMap;
    }
}
