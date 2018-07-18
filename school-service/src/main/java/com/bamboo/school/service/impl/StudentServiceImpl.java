package com.bamboo.school.service.impl;

import com.bamboo.entity.school.SchoolStudent;
import com.bamboo.entity.system.User;
import com.bamboo.school.mapper.StudentMapper;
import com.bamboo.school.service.StudentService;
import com.bamboo.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生服务
 * Created by yklin on 2018/5/10.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<SchoolStudent> queryStudent(SchoolStudent stu) {
        List<User> users = userMapper.queryAll();
        List<SchoolStudent> students = studentMapper.queryStudent();
        return students;
    }
}
