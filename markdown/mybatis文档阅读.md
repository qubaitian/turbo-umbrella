# 配置

MyBatis 的配置文件包含了会深深影响 MyBatis 行为的设置和属性信息。 配置文档的顶层结构如下：

- configuration
    - properties(属性)
    - setting(设置)
    - typeAliases(类型别名)
    - typeHandlers(类型处理器)
    - objectFactory(对象工厂)
    - plugin
    - environments(环境配置)
        - environment(环境变量)
            - transactionManager(事务管理器)
            - datasource(数据源)
    - databaseIdProvider（数据库厂商标识）
    - mappers(映射器)         