package com.example.demo;

import cn.hutool.json.JSONUtil;
import com.example.demo.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ChangYu
 * @Date: 5/22/2019 3:46 PM
 * @Version 1.0
 */
public class Test {
    public static void main(String args[]){
        Map<String, String> map = new HashMap<String, String>() {{
            put("username", "changyu");
        }};
        User user = JSONUtil.toBean(JSONUtil.parseFromMap(map), User.class);
        System.out.println(user.toString());

    }
}
