package com.bamboo.feign.controller;

import com.bamboo.entity.school.SchoolStudent;
import com.bamboo.feign.client.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 学生控制中心
 * Created by yklin on 2018/5/10.
 */
@Controller
@RequestMapping("stu")
public class StudentController {

    @Autowired
    private StudentClient studentClient;

    @RequestMapping(value = "/queryStudent", method = RequestMethod.GET)
    @ResponseBody
    public String queryStudent() {
        List<SchoolStudent> student = studentClient.queryStudent();
        return null;
    }
}
