package com.bamboo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
//如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.bamboo.system.mapper")//注入mapper
@EnableCaching//开启缓存
public class SystemApplication {

//    public static void main(String[] args) {
////        为了模拟集群 端口采用控制台输入的形式启动
//        Scanner scanner = new Scanner(System.in);
//        String port = scanner.nextLine();
//        new SpringApplicationBuilder(SystemApplication.class)
//                .properties("server.port=" + port).run(args);
//    }

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}
}
