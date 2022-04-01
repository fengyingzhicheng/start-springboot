package com.flyin.example.config;

/**
 * @author 王军
 * @description
 * @date 2022/3/25 14:05
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 注入 zookeeper 的配置信息
 * @author fengying
 */
@Component
@ConfigurationProperties(prefix = "zookeeper")
@Data
public class ZookeeperProperties {
    private int baseSleepTimeMs;
    private int maxRetries;
    private String connectString;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;
}