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

| 技术                 | 说明                             | 官网                                                 |
| -------------------- | -------------------------------- | ---------------------------------------------------- |
| SpringBoot           | Container + MvC Framework        | https://spring.io/projects/spring-boot               |
| SpringSecurity       | Authencation and Authorization   | https://spring.io/projects/spring-security           |
| MyBatis              | ORM Framework                    | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisGenerator     | Data layer generation            | http://www.mybatis.org/generator/index.html          |
| PageHelper           | MyBatis page plugin              | http://git.oschina.net/free/Mybatis_PageHelper       |
| Swagger-UI           | Document generation tool         | https://github.com/swagger-api/swagger-ui            |
| Hibernator-Validator | Validation Framework             | http://hibernate.org/validator                       |
| Elasticsearch        | Search engine                    | https://github.com/elastic/elasticsearch             |
| RabbitMq             | message queue                    | https://www.rabbitmq.com/                            |
| Redis                | Cache Distribution               | https://redis.io/                                    |
| MongoDb              | NoSql Database                   | https://www.mongodb.com                              |
| Docker               | Application Container Engine     | https://www.docker.com                               |
| Druid                | Datasource Connection Pool       | https://github.com/alibaba/druid                     |
| OSS                  | Object Storage                   | https://github.com/aliyun/aliyun-oss-java-sdk        |
| MinIO                | Object Storage                   | https://github.com/minio/minio                       |
| JWT                  | JWT Login Support                | https://github.com/jwtk/jjwt                         |
| LogStash             | Log Collection Tool              | https://github.com/logstash/logstash-logback-encoder |
| Lombok               | Simplified Object Encaption Tool | https://github.com/rzwitserloot/lombok               |
| Jenkins              | Auto Deployment Tool             | https://github.com/jenkinsci/jenkins                 |
| Dubbo                | RPC                              |                                                      |
| Mycat                |                                  |                                                      |
| Kibana               |                                  |                                                      |
| Helm                 | CI/CD Tool                       |                                                      |
| Harbor               | CI/CD Tool                       |                                                      |
| Kubernetes           |                                  |                                                      |
| Filebeate            |                                  |                                                      |
| Promethues           |                                  |                                                      |
| Granfana             |                                  |                                                      |
| Mysql                |                                  |                                                      |
|                      |                                  |                                                      |
|                      |                                  |                                                      |

##### Demo

![Backend Demostration](/document/resource/mall-admin.gif)







