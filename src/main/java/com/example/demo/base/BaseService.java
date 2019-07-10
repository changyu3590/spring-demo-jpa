package com.example.demo.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ChangYu
 * @Date: 5/31/2019 10:56 AM
 * @Version 1.0
 */
public class BaseService<R> {

    public static Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    public R dao;


}
