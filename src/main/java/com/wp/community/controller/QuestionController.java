/**
 * FileName: QuestionController
 * Author: WP
 * Date: 2019/12/22 16:21
 * Description:
 * History:
 **/
package com.wp.community.controller;

import com.wp.community.dto.QuestionDTO;
import com.wp.community.mapper.QuestionMapper;
import com.wp.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //根据id获得 问题页面，将 id作为请求路径的一部分，因为id唯一，所以由此得到的 问题页面 也是唯一的
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model){

        QuestionDTO questionDTO = questionService.getById(id);
        //累计阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
