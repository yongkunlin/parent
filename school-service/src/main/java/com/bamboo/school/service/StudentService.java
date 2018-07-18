package com.bamboo.school.service;

import com.bamboo.entity.school.SchoolStudent;

import java.util.List;

/**
 * 学生逻辑接口
 * Created by yklin on 2018/5/10.
 */
public interface StudentService {

    List<SchoolStudent> queryStudent(SchoolStudent stu);
}
