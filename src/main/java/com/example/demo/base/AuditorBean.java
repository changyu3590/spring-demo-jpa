package com.example.demo.base;

import com.example.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @Author: ChangYu
 * @Date: 7/11/2019 10:04 AM
 * @Version 1.0
 */
@Configuration
public class AuditorBean implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return Optional.of(user.getUsername());
    }
}
