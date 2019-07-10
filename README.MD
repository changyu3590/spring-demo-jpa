框架介绍
====
所用到的环境及中间件：
----
        1、JDK:1.8
        2、springBoot 2.0.2
        3、spring 5.0.6
        4、redis 缓存
        5、jackson 2.9.8
        6、mysql  关系型数据库
        7、swagger2   api框架
框架基本结构：
-----
         核心框架：springBoot
         安全框架：shiro+redis
         持久层框架：mybatis-plus
         2、base:基础的封装类
         3、config:基础的配置类
         4、controller:控制层
         5、cronJon:定时任务
         6、dao:持久层
         7、dto:报文
         8、entity:实体类，表
         9、serviceImp:业务层
         10、utils:工具包
框架基本功能：
----
        1、基本的CRUD
        2、RedisUtil已封装，可使用
        5、Session分布式实现，会对在线用户过期认证(shrio+redis权限、session认证)
        7、动态多数据源 https://mp.baomidou.com/guide/dynamic-datasource.html
        8、swagger2  已整合
        9、统一的报文处理，异常处理、请求日志打印(AOP)
        10、纳入了非常丰富的工具类 hutool  https://github.com/changyu3590/hutool.git
        12、已配置路由拦截器
        14、支持事务
        15、定时任务
        16、基于mybatis-plus的审计(公共字段自动填充)
