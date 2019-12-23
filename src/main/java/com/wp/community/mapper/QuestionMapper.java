package com.wp.community.mapper;

import com.wp.community.dto.QuestionDTO;
import com.wp.community.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    //插入问题
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    //首页问题 分页
    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    //查询问题总数
    @Select("select count(*) from question")
    Integer count();

    //个人问题分页查询
    @Select("select * from question where creator = #{userId} limit #{offset}, #{size}")
    List<Question> listByUserId(@Param(value = "userId")Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    //个人问题 总数
    @Select("select count(*) from question where creator = #{userId}")
    Integer countByUserId(@Param(value = "userId")Integer userId);

    //个人全部问题
    @Select("select * from question where id = #{id}")
    Question getById(@Param(value = "id")Integer id);

    //更新问题
    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmtModified}, tag = #{tag} where id = #{id}")
    void update(Question question);
}
