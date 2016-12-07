package com.cn.config.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.rmi.registry.Registry;

/**
 * Created by Administrator on 2016/12/6.
 */
@Configuration
@PropertySource(value = "classpath:dubbo/dubbo.properties")
public class DubboConfiguration {
    @Value("${dubbo.application.name}")
    private String applicationName;

    @Value("${dubbo.protocol.name}")
    private String protocolName;

    @Value("${dubbo.protocol.port}")
    private int protocolPort;

    @Value("${dubbo.protocol.thread.count}")
    private int protocolThreadCount;

    @Value("${dubbo.registry.protocol}")
    private String protocol;

    @Value("${dubbo.registry.address}")
    private String registryAddress;

    @Value("${dubbo.provider.timeout}")
    private int timeout;

    @Value("${dubbo.provider.retries}")
    private int retries;

    @Value("${dubbo.provider.delay}")
    private int delay;
    /**
     * 设置dubbo的扫描包路径
     * @param annotationPackage
     * @return
     */
    @Bean
    public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String annotationPackage){
        System.out.println("annotationBean>>>>>>>>"+annotationPackage);
        AnnotationBean annotationBean=new AnnotationBean();
        annotationBean.setPackage(annotationPackage);
        return annotationBean;
    }

    /**
     * 注入dubbo上下文
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig(){
        System.out.println("applicationConfig>>>>>>>>"+applicationName);
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    /**
     * 注入dubbo注册中心配置,基于zookeeper
     * @return
     */
    @Bean
    public RegistryConfig registryConfig(){
        System.out.println("registryConfig>>>>>>>>"+protocol+"----------"+registryAddress);
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setProtocol(protocol);
        registryConfig.setAddress(registryAddress);
        registryConfig.setTimeout(timeout);
        return registryConfig;
    }

    /**
     * 默认基于dubbo协议提供服务
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig(){
        System.out.println("protocolConfig>>>>>>>>"+protocolName+"----------"+protocolPort+"----------"+protocolThreadCount);
        ProtocolConfig protocolConfig=new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        protocolConfig.setThreads(protocolThreadCount);
        return protocolConfig;
    }

    /**
     * dubbo提供服务
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @return
     */
    @Bean
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig,RegistryConfig registryConfig,ProtocolConfig protocolConfig){
        System.out.println("providerConfig>>>>>>>>"+timeout+"----------"+retries+"----------"+delay);
        ProviderConfig providerConfig=new ProviderConfig();
        providerConfig.setTimeout(timeout);
        providerConfig.setRetries(retries);
        providerConfig.setDelay(delay);
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        return  providerConfig;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        System.out.println(applicationName);
        this.applicationName = applicationName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public int getProtocolPort() {
        return protocolPort;
    }

    public void setProtocolPort(int protocolPort) {
        this.protocolPort = protocolPort;
    }

    public int getProtocolThreadCount() {
        return protocolThreadCount;
    }

    public void setProtocolThreadCount(int protocolThreadCount) {
        this.protocolThreadCount = protocolThreadCount;
    }
}
