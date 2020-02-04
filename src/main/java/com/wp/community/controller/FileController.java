/**
 * FileName: FileController
 * Author: WP
 * Date: 2020/2/3 10:00
 * Description:
 * History:
 **/
package com.wp.community.controller;

import com.wp.community.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(){
        return null;
    }
}
