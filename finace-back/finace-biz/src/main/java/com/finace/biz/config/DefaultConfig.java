package com.finace.biz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 工具类Bean的配置
 */
@Configuration
public class DefaultConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        //配置密码加密，这里声明成bean，方便注册用户时直接注入
        return new BCryptPasswordEncoder();
    }
}