package com.wp.community.controller;

import com.wp.community.dto.PaginationDTO;
import com.wp.community.dto.QuestionDTO;
import com.wp.community.mapper.QuestionMapper;
import com.wp.community.mapper.UserMapper;
import com.wp.community.model.Question;
import com.wp.community.model.User;
import com.wp.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                       @RequestParam(name = "size",defaultValue = "5")Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                if("token".equals(cookie.getName())){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        //登陆成功，将user加入到session中
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        //获得DTO对象，目的是为了获取登录用户的头像
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
