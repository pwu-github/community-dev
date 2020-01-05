/**
 * FileName: CommentService
 * Author: WP
 * Date: 2020/1/5 16:43
 * Description:
 * History:
 **/
package com.wp.community.service;

import com.wp.community.enums.CommentTypeEnum;
import com.wp.community.exception.CustomizeErrorCode;
import com.wp.community.exception.CustomizeException;
import com.wp.community.mapper.CommentMapper;
import com.wp.community.mapper.QuestionMapper;
import com.wp.community.model.Comment;
import com.wp.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public void insert(Comment comment){
        if(comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExit(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()){
            Comment dbcomment = commentMapper.selectByPrimaryKey(comment.getId());
            if (dbcomment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }
    }
}
