package com.example.demo.config.interceptor;

import com.example.demo.base.TimeoutException;
import com.example.demo.config.redis.RedisUtil;
import com.example.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;
/**
 * @Author: ChangYu
 * @Version 1.0
 */
/**
 * 拦截器
 */
@Configuration
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;
    @Value("${spring.session.timeout}")
    private int timeout;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long stime=System.currentTimeMillis();
        request.setAttribute("stime",stime);
        ssoCheck(request);
        return true;
    }

    /**
     * 用户异地登录检查
     *
     * @param request
     */
    private void ssoCheck(HttpServletRequest request) {
        String sessionId = request.getRequestedSessionId();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        logger.info("当前用户ID：" + user.getId() + "会话ID：" + sessionId);
        if (redisUtil.existsKey(user.getId().toString())) {
            if (redisUtil.get(user.getId().toString()).equals(sessionId)) {
                redisUtil.expireKey(user.getId().toString(), sessionId, timeout, TimeUnit.SECONDS);
            } else {
                throw new TimeoutException("您已经在其他地方登录，请重新登录");
            }
        } else {
            throw new TimeoutException("请先登录");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long etime=System.currentTimeMillis();
        logger.info(String.format("[时间消耗:%s ms]", etime - Long.parseLong(request.getAttribute("stime").toString())));
    }
}
