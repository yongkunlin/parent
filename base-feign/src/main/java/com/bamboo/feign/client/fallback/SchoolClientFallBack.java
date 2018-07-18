package com.bamboo.feign.client.fallback;

import com.bamboo.entity.school.SchoolStudent;
import com.bamboo.feign.client.StudentClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 断熔实现
 * Created by yklin on 2018/5/10.
 */
@Component
public class SchoolClientFallBack implements StudentClient {
    @Override
    public List<SchoolStudent> queryStudent() {
        return null;
    }
}
