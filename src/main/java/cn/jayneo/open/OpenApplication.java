package cn.jayneo.open;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.jayneo.open.mapper")
public class OpenApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApplication.class, args);
    }

}
