package com.bamboo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

//如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
//如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
@EnableEurekaClient
@SpringBootApplication
//阻止spring boot自动注入dataSource bean
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@MapperScan({"com.bamboo.system.mapper", "com.bamboo.school.mapper"})
//@ComponentScan("com.bamboo.system.mapper")
public class SchoolApplication {

    public static void main(String[] args) {
//        为了模拟集群 端口采用控制台输入的形式启动
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(SchoolApplication.class)
                .properties("server.port=" + port).run(args);
    }

//	public static void main(String[] args) {
//		SpringApplication.run(SchoolWebApplication.class, args);
//	}
}
