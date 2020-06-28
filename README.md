#   Introduce

​	Eshop is an online saling mall system, a microservice based distributed one deployed on kubernetes cluster installed by RKE managed by rancher. 

​	As to business is concerted, Eshop can be brokendown into four microservices: admin, security, ums(user management microservice), pms(product management microservice), sms(sale management microservice), and oms(order management microservice).

​	As to techniques are concerted, Eshop is composed of the frontline and backend independently, the frontline is developed by Vue build by node.js using ElementUI runing in Nginx, while the backend is splited into mutiple mircroservices which are developed by Springboot communicated by Dubbo rpc.

# Pre-requisite

1. CentOS 7
2. Kubernetes v1.17.6
3. RKE v1.1.2
4. Rancher v2.4.4

# Frontline Project

##### Technologies

| Techniques        | Description                        | Official sites                                               |
| ----------------- | ---------------------------------- | ------------------------------------------------------------ |
| Vue               | Frontline Framework                | [https://vuejs.org/](https://vuejs.org/)                     |
| Vue-router        | Router Framework                   | [https://router.vuejs.org/](https://router.vuejs.org/)       |
| Vuex              | Global states management Framework | [https://vuex.vuejs.org/](https://vuex.vuejs.org/)           |
| Element           | UI Framework                       | [https://element.eleme.io/](https://element.eleme.io/)       |
| Axios             | Frontline Http Framework           | [https://github.com/axios/axios](https://github.com/axios/axios) |
| v-charts          | Graphics Framework ased on Echarts | [https://v-charts.js.org/](https://v-charts.js.org/)         |
| Js-cookie         | Cookie Management Tool             | [https://github.com/js-cookie/js-cookie](https://github.com/js-cookie/js-cookie) |
| nprogress         | Progress Control Component         | [https://github.com/rstacruz/nprogress](https://github.com/rstacruz/nprogress) |
| vue-element-admin | Project Skeleton Reference         | [https://github.com/PanJiaChen/vue-element-admin](https://github.com/PanJiaChen/vue-element-admin) |

##### Project Layout

```lua
src -- source codes
├── api -- axios network request definition
├── assets -- static image files
├── components -- common components
├── icons -- svg vector image files
├── router -- vue-router setting 
├── store -- vuex states management
├── styles -- global css styles
├── utils -- tool libaries
└── views -- flontline views
    ├── home -- home
    ├── layout -- common views loaded framework 
    ├── login -- login view
    ├── oms -- order module views
    ├── pms -- product module views
    └── sms -- sale module views
```

##### Install

- Download and install node: [https://nodejs.org/dist/v12.14.0/node-v12.14.0-x64.msi](https://nodejs.org/dist/v12.14.0/node-v12.14.0-x64.msi);
- Install local backend environment for this frontline-backend project;
- Set BASE_API=http://localhost:8080 in the setting file of config/dev.env.js ;
- Create a project by IDEA and import source mall-frontline into the project and compile this project;
- Execute this command: "npm install" in IDEA terminal and then download the related node dependencies;
- Execute command  "npm run dev" in IDEA terminal;
- Address http://localhost:8090 to access backend management system;
- `Caution`：if npm command could not be run,please append C:\Users\\[your loging username]\AppData\Roaming\npm to the system variable - path;

# Backend Project

##### Technologies

| 技术                 | 说明                | 官网                                                 |
| -------------------- | ------------------- | ---------------------------------------------------- |
| SpringBoot           | 容器+MVC框架        | https://spring.io/projects/spring-boot               |
| SpringSecurity       | 认证和授权框架      | https://spring.io/projects/spring-security           |
| MyBatis              | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisGenerator     | 数据层代码生成      | http://www.mybatis.org/generator/index.html          |
| PageHelper           | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper       |
| Swagger-UI           | 文档生产工具        | https://github.com/swagger-api/swagger-ui            |
| Hibernator-Validator | 验证框架            | http://hibernate.org/validator                       |
| Elasticsearch        | 搜索引擎            | https://github.com/elastic/elasticsearch             |
| RabbitMq             | 消息队列            | https://www.rabbitmq.com/                            |
| Redis                | 分布式缓存          | https://redis.io/                                    |
| MongoDb              | NoSql数据库         | https://www.mongodb.com                              |
| Docker               | 应用容器引擎        | https://www.docker.com                               |
| Druid                | 数据库连接池        | https://github.com/alibaba/druid                     |
| OSS                  | 对象存储            | https://github.com/aliyun/aliyun-oss-java-sdk        |
| MinIO                | 对象存储            | https://github.com/minio/minio                       |
| JWT                  | JWT登录支持         | https://github.com/jwtk/jjwt                         |
| LogStash             | 日志收集工具        | https://github.com/logstash/logstash-logback-encoder |
| Lombok               | 简化对象封装工具    | https://github.com/rzwitserloot/lombok               |
| Jenkins              | 自动化部署工具      | https://github.com/jenkinsci/jenkins                 |
| Dubbo                | RPC                 |                                                      |
| Mycat                |                     |                                                      |
| kibana               |                     |                                                      |
| Jenkins              | CI/CD Tool          |                                                      |
| Helm                 | CI/CD Tool          |                                                      |
| Harbor               | CI/CD Tool          |                                                      |
| Kubernetes           |                     |                                                      |
| Filebeate            |                     |                                                      |
| Kibana               |                     |                                                      |
| Promethues           |                     |                                                      |
| Granfana             |                     |                                                      |
| Mysql                |                     |                                                      |
|                      |                     |                                                      |
|                      |                     |                                                      |

# Demo

![Backend Demostration](/document/resource/mall-admin.gif)











