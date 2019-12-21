package com.wp.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {

    private List<QuestionDTO> questions;
    //前一页
    private boolean showPrevious;
    //第一页
    private boolean showFirstPage;
    //下一页
    private boolean showNext;
    //最后页
    private boolean showEndPage;
    //当前页
    private Integer page;
    //每页展示的按钮 页码 数组
    private List<Integer> pages = new ArrayList<>();
    //总页数
    private Integer totalPage;

    //用于设置页面展示的页数
    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;
        pages.add(page);
        for(int i = 1;i <= 3;i++){
            if(page - i > 0){
                pages.add(0,page - i);
            }
            if(page + i <= totalPage){
                pages.add(page + i);
            }
        }
        //是否展示上一页，当处于第一页时，不需要展示上一页按钮
        if(page == 1){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        //是否展示下一页，当处于最后一页时，不需要展示下一页按钮
        if(page == totalPage){
            showNext = false;
        }else{
            showNext = true;
        }
        //是否展示第一页按钮，当前的pages 页面集合中，不包括第一页，则展示第一页按钮
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        //是否展示最后一页按钮，当前pages 页面集合中，不包含最后一页，则展示最后一页按钮
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }

    }
}
