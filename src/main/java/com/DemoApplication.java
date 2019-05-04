package com;

import com.redis.cofig.RedisConfig;
import com.swagger.Swagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ImportResource(locations = "classpath*:/*.sql")
@Import(value={RedisConfig.class,Swagger.class})
@EnableCaching
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
