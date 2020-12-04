package cn.telltao.dubbo.server;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class TelltaoDubboServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(TelltaoDubboServerApplication.class, args);
        System.out.printf("******项目启动成功");
    }

}
