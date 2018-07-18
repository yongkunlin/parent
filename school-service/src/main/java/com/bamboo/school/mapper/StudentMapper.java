package com.bamboo.school.mapper;

import com.bamboo.entity.school.SchoolStudent;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 学生数据操作
 * Created by yklin on 2018/5/10.
 */
//@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM school_student")
    List<SchoolStudent> queryStudent();
}
