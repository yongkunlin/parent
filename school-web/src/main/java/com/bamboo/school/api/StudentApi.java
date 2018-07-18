package com.bamboo.school.api;

import com.bamboo.entity.school.SchoolStudent;
import com.bamboo.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生
 * Created by yklin on 2018/5/10.
 */
@RestController
@RequestMapping("api/stu")
public class StudentApi {

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生
     *
     * @param stu
     * @return
     */
    @RequestMapping("queryStudent")
    public List<SchoolStudent> queryUser(SchoolStudent stu) {
        List<SchoolStudent> studen = studentService.queryStudent(stu);
        return studen;
    }

}
