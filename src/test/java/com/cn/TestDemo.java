package com.cn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2016/11/9.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TestDemo {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String eurekaServiceUrl;

    @Test
    public void getProfile(){
        System.out.println(applicationName+","+port+","+profile+","+eurekaServiceUrl);
    }
}
