package com.cn.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by Administrator on 2016/12/6.
 */
@Service(version = "1.0.0")
public class HelloRegistryService implements IHelloRegistryService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello dubbo-" + name);
    }
}
