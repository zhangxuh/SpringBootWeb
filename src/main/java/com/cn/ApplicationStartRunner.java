package com.cn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/23.
 */
@Component
@Order(value = 1)//执行权值，值越低 等级越高
public class ApplicationStartRunner implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        System.out.println(Arrays.asList(strings));
    }
}
